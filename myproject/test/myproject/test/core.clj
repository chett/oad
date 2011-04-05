(ns myproject.test.core
  (:use [myproject.core] :reload)
  (:use [clojure.test]))

(deftest open-tag-test
  (is (.equals (open-tag "p")
	       "<p>")))

(deftest close-tag-test
  (is (.equals (close-tag "p")
	       "</p>")))

(deftest wrap-tag-test
  (is (.equals (wrap-tag "test" "h1")
	       "<h1>test</h1>")))

(deftest make-add-url-test
  (is (.equals (make-name-url "chet" true true)
      "http://chett.xen.prgmr.com:8080/add/first/chet")))

(deftest make-add-url-test-middle
  (is (.equals (make-name-url "chet" true false)
	       "http://chett.xen.prgmr.com:8080/add/middle/chet")))

(deftest make-set-url-test
  (is (.equals (make-set-url "tobrey")
	       "http://chett.xen.prgmr.com:8080/set/last/tobrey")))

(deftest make-remove-url-test
  (is (.equals (make-name-url "wally" false false)
	       "http://chett.xen.prgmr.com:8080/remove/middle/wally")))