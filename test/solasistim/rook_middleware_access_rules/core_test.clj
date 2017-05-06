(ns solasistim.rook-middleware-access-rules.core-test
  (:require [clojure.test :refer :all]
            [solasistim.rook-middleware-access-rules :as core]
            [buddy.auth.accessrules :as accessrules]
            [io.aviso.rook :as rook]
            [ring.util.response :as r]
            [ring.mock.request :as mock]))

(defn error-policy [request rejection-value]
  (-> nil (r/response) (r/status 401)))

(defn make-handler []
  (rook/namespace-handler
   {:default-middleware (core/make-access-rule-middleware error-policy)}
   ['solasistim.rook-middleware-access-rules.target-test-ns]))

(deftest unrestricted-works
  (let [request (mock/request :get "/unrestricted")
        handler (make-handler)]
    (let [response (handler request)]
      (is (= {:ok true} (:body response))))))


(deftest restricted-works
  (let [request (mock/request :get "/restricted-always-fail")
        handler (make-handler)]
    (let [response (handler request)]
      (is (= 401 (:status response))))))


