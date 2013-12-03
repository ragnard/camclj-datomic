(ns camclj-datomic.schemas
  (:require [datomic.api :as d]))


(defn email-birthdate
  []
  [{:db/id                 (d/tempid :db.part/db)
    :db/ident              :email
    :db/valueType          :db.type/string
    :db/cardinality        :db.cardinality/one
    :db/doc                "An email address"
    :db/index              true
    :db/unique             :db.unique/identity
    :db.install/_attribute :db.part/db}

   {:db/id                 (d/tempid :db.part/db)
    :db/ident              :birthdate
    :db/valueType          :db.type/instant
    :db/cardinality        :db.cardinality/one
    :db/doc                "A date of birth"
    :db.install/_attribute :db.part/db}])






