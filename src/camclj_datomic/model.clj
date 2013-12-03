(ns camclj-datomic.model)


(def alice
  {:email "alice@mail.com"
   :birthdate #inst "1970-11-01"})

(def bob
  {:email "bob@mail.com"
   :birthdate #inst "1950-10-22"})



;; entity -> attributes -> value(s)

;; t0

[1 :email "alice@mail.com"]
[1 :birthdate #inst "1970-11-01"]


;; t1

[2 :email "bob@mail.com"]
[2 :birthdate #inst "1950-10-22"]
