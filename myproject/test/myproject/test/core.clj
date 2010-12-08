(ns myproject.test.core
  (:use [myproject.core] :reload)
  (:use [clojure.test]))


(deftest open-tag-test
  (is (open-tag "p") "<p>"))

(deftest close-tag-test
  (is (close-tag "p") "</p>"))

(deftest wrap-tag-test
  (is (wrap-tag "H1" "test") "<h1>test</h1>"))