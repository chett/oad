(ns myproject.test.core
  (:use [myproject.core] :reload)
  (:use [clojure.test]))

(deftest replace-me ;; FIXME: write
  (= false false "No tests have been written."))

(deftest asdf-test
  (= nil (println 'asdf)))

;(deftest addh1-test []
;  (= "<h1>1</h1>" (addh1 "1")))