(ns myproject.test.ch3test
  (:use [myproject.ch3] :reload)
  (:use [clojure.test]))

;; calling java
(deftest dot-test
  (is (integer? (. rnd nextInt))
      (< (. rnd nextInt 10) 10)))

;;importing java class
(deftest call-java-test
  (is (= java.util.Date 
	 (.getClass (now)))))

(deftest dot-dot-test
  (is (= java.lang.String
	 (.. (now) getTime toString getClass))))

(deftest aget-test
  (is (= "asdf"
	 (aget (into-array String ["asd" "asdf"])
	       1))))
(deftest amap-test
  (is (=
       (first (let [sa (into-array ["some" "string" "here"])
		   sa2 (seq (amap sa idx _ (.toUpperCase (aget sa idx))))]
	       sa2))
	 "SOME")))