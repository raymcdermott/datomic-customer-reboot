(defproject datomic-customer-reboot"0.1.0-SNAPSHOT"
            :description "FIXME: write description"
            :url "http://example.com/FIXME"
            :license {:name "Eclipse Public License"
                      :url  "http://www.eclipse.org/legal/epl-v10.html"}
            :repositories {"my.datomic.com" {:url   "https://my.datomic.com/repo"
                                             :creds :gpg}}
            :dependencies [[org.clojure/clojure "1.6.0"]
                           [com.datomic/datomic-pro "0.9.5078" :exclusions [joda-time]]]
            :main ^:skip-aot datomic-customer.core
            :target-path "target/%s"
            :profiles {:uberjar {:aot :all}})
