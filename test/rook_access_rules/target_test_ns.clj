(ns rook-access-rules.target-test-ns
  (:require [ring.util.response :as r]))

(defn index []
  (r/response {:ok true}))

