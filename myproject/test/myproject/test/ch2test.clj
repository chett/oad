(ns myproject.test.ch2test
  (:use [myproject.ch2] :reload)
  (:use [clojure.test]))

;;pg 31
(deftest encode-test
  (is (= (encode ["xxx" "yyy" "zzz"])
	 "xyzxyzxyz")))