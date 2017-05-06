(ns rook-access-rules.core
  (:require [buddy.auth.accessrules :as accessrules]))


(defn wrap-with-access-rules [endpoint-handler metadata]
  (when-let [rule-handler (:access-rule metadata)]
    (accessrules/restrict endpoint-handler
                          {:handler rule-handler})))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
