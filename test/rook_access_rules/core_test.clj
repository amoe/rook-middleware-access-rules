(ns rook-access-rules.core-test
  (:require [clojure.test :refer :all]
            [rook-access-rules.core :refer :all]
            [io.aviso.rook :as rook]
            [ring.mock.request :as mock]))

(defn make-handler []
  (rook/namespace-handler ['rook-access-rules.target-test-ns]))

(deftest a-test
  (let [request (mock/request :get "/unrestricted")
        handler (make-handler)]
    (let [response (handler request)]
      (is (= {:ok true} (:body response))))))

