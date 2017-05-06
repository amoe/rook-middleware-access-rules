(ns rook-access-rules.core-test
  (:require [clojure.test :refer :all]
            [rook-access-rules.core :as core]
            [buddy.auth.accessrules :as accessrules]
            [io.aviso.rook :as rook]
            [ring.mock.request :as mock]))

(defn make-handler []
  (rook/namespace-handler
   {:default-middleware core/wrap-with-access-rules}
   ['rook-access-rules.target-test-ns]))

(deftest a-test
  (let [request (mock/request :get "/unrestricted")
        handler (make-handler)]
    (let [response (handler request)]
      (is (= {:ok true} (:body response))))))


(deftest a-test
  (let [request (mock/request :get "/restricted-always-fail")
        handler (make-handler)]
    (let [response (handler request)]
      (is (= 401 (:status response))))))


