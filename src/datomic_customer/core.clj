(ns datomic-customer.core
  (:require [clojure.set :as set]
            [datomic.api :as d]))

(def uri "datomic:dev://localhost:4334/customer")

(d/create-database uri)

(def conn (d/connect uri))
(def db (d/db conn))

; add customer schema
(def customer-schema-tx (read-string (slurp "resources/customer-schema.edn")))
@(d/transact conn customer-schema-tx)

; add contact schema
(def contact-schema-tx (read-string (slurp "resources/contacts-schema.edn")))
@(d/transact conn contact-schema-tx)


;; add sample customer & contact
(def data-tx (read-string (slurp "resources/customer-data.edn")))
@(d/transact conn data-tx)

(defn results [](d/q '[:find ?c :where [?c :person/first-name]] (db conn)))

(clojure.pprint/pprint results)

;
;(defn -main
;  [& args]
;(count (results)))
