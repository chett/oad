(ns myproject.test.ch1test
  (:use [myproject.ch1] :reload)
  (:use [clojure.test]))

(deftest asdf-test
  (is (= nil (println 'asdf))))

(deftest goodbye-test
  (is (=(goodbye "waldo") "goodbye, waldo")))
;;pg 6
(deftest vec-comma-test
  (is ( = [11, 22, 33] [11 22 33])))
;;pg 7
(deftest cond-test
  (is (= false (cond (< 4 3) true
		     (> 5 3) false))))