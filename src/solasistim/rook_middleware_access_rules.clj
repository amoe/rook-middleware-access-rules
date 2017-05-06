(ns solasistim.rook-middleware-access-rules
  (:require [buddy.auth.accessrules :as accessrules]))

(defn make-access-rule-middleware [error-policy]
  (fn [endpoint-handler metadata]
    (when-let [rule-handler (:access-rule metadata)]
      (accessrules/restrict endpoint-handler
                            {:handler rule-handler
                             :on-error error-policy}))))
