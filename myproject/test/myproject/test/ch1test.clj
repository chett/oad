(ns myproject.test.ch1test
  (:use [myproject.ch1] :reload)
  (:use [clojure.test]))

(deftest asdf-test
  (= nil (println 'asdf)))

;(deftest addh1-test []
;  (= "<h1>1</h1>" (addh1 "1")))