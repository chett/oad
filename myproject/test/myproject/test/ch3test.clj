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