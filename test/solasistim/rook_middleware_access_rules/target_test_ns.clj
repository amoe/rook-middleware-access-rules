(ns solasistim.rook-middleware-access-rules.target-test-ns
  (:require [ring.util.response :as r]
            [buddy.auth.accessrules :as accessrules]))

(defn always-fail [request]
  (accessrules/error))

(defn unrestricted-handler
  {:route [:get ["unrestricted"]]}
  []
  (println "inside unrestricted handler")
  (r/response {:ok true}))

(defn restricted-handler
  {:route [:get ["restricted-always-fail"]]
   :access-rule always-fail}
  []
  (r/response {:ok true}))

