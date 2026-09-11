(ns ordinance.facts-test
  (:require [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest guatemala-city-has-spec-basis
  (let [sb (facts/spec-basis "guatemala-city")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:ordinance/url %) "https://") sb))
    (is (every? :ordinance/number sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "antigua")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["guatemala-city" "antigua"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["antigua"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= 2 (count (facts/by-topic "guatemala-city" :governance))))
  (is (empty? (facts/by-topic "guatemala-city" :labor)))
  (is (empty? (facts/by-topic "antigua" :governance))))
