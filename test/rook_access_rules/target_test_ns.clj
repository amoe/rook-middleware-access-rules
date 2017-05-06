(ns rook-access-rules.target-test-ns
  (:require [ring.util.response :as r]))

(defn unrestricted-handler
  {:route [:get ["unrestricted"]]}
  []
  (r/response {:ok true}))

