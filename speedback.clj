#!/usr/bin/env bb

(require '[clojure.string :refer [join]])

(defn evenify [coll default]
  (if (even? (count coll)) coll (cons default coll)))

;; Logic of the next two methods taken here
;; https://stackoverflow.com/questions/41896889/algorithm-to-schedule-people-to-an-activity-that-should-be-done-in-pairs#41897430
;; https://en.wikipedia.org/wiki/Round-robin_tournament#Scheduling_algorithm
(defn rotate-for-next-round [[anchor & to-cycle :as coll]]
  (cons anchor (take (count to-cycle) (rest (cycle to-cycle)))))

(defn round-robin-coll-to-pairs [coll]
  (->> coll
       (split-at (/ (count coll) 2))
       ((fn [[a b]] [a (reverse b)])) ;; this line could be improved :)
       (apply interleave)
       (partition 2)))

(defn speedback-schedule [folks]
  (loop [coll (evenify folks "BREAK") result []]
    (if (= (dec (count coll)) (count result))
      result
      (recur (rotate-for-next-round coll) (cons (round-robin-coll-to-pairs coll) result)))))

(defn format-pair [pair]
  (join "/" pair))

(defn format-line [line]
  (join ", " (map format-pair line)))

(defn format-schedule [lines]
  (join "\n" (map format-line lines)))

(println
 (if (some? *command-line-args*)
   (-> *command-line-args* speedback-schedule format-schedule)
   "Please pass some argument in :)"))
