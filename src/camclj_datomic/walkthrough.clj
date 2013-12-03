(ns camclj-datomic.walkthrough
  (:require [datomic.api :as d]
            [clojure.pprint :refer [pprint] :rename {pprint pp} ]
            [camclj-datomic.schemas]))

(def transactor-uri "datomic:free://localhost:4334/")

(def db-uri (str transactor-uri "camclj"))

(pp db-uri)

;; managing databases

(pp (d/delete-database db-uri))

(pp (d/create-database db-uri))


;; connecting

(def conn (d/connect db-uri))



(d/transact conn (camclj-datomic.schemas/email-birthdate))

(comment


  (d/transact conn [{:db/id     (d/tempid :db.part/user)
                     :email     "alice@mail.com"
                     :birthdate #inst "1970-11-01"}
                    {:db/id     (d/tempid :db.part/user)
                     :email     "bob@gmail.com"
                     :birthdate #inst "1950-10-22"}])

  


  )








;;--------------------------------------------------------------------
;; query

(comment
  (pp (d/q '[:find ?e ?email
             :where [?e :email ?email]]
           (d/db conn)))

  (pp (first (d/q '[:find ?e ?email
                    :where [?e :email ?email]]
                  (d/db conn))))

  (d/touch (d/entity (d/db conn) 17592186045419)))


