(ns myproject.test.ch2test
  (:use [myproject.ch2] :reload)
  (:use [clojure.test])
  (:use [clojure.contrib.str-utils :only (re-split)]))

;;pg 31
(deftest encode-test
  (is (= (encode ["xxx" "yyy" "zzz"])
	 "xyzxyzxyz")))

;;pg 37
(deftest hello-arity-test
  (is (.equals "Hello, world" (hello-arity))))

;;pg 38
(deftest filter-test
  (is (= (long-filter)
	 (filter (fn [w] (> (count w) 2))
		 (re-split #"\W" "A quick fox jumped over a brown  dog")))))
;;pg 39
(deftest filter-test-2
  (is (= (filter #(> (count %) 2)
		 (re-split #"\W" "A quick fox jumped over a brown  dog"))
	 (long-filter)
	 (indexable-words "A quick fox jumped over a brown  dog"))))

;;pg 40
(deftest greeter-ter
  (let [hawaiian-greeter (make-greeter "Aloha")]
    (is (= (hawaiian-greeter "ted")
	   "Aloha, ted"))))