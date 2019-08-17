(ns haunted-house.core
  (:require [clojure.string :as st]
            ["pad-right" :as pad-right]
            ["readline-sync" :as rl]
            ["super-scared" :as scare]))

(def rooms [:kitchen :attic :basement])

(def monsters {:kitchen :cockroach
               :attic :ghost
               :basement :spider})

(def scares {:cockroach 4
             :ghost 8
             :spider 5})

(defn- room-name
  [room]
  (st/capitalize (name room)))

(defn- room-names
  [rooms]
  (map room-name rooms))

(defn- ask-room
  []
  (-> rooms
      room-names
      clj->js
      (rl/keyInSelect "Where do you go?" #js{:cancel false})
      rooms))

(defmulti jump-scare identity)

(defmethod jump-scare :cockroach
  [_]
  (js/console.log "It skitters across the floor out of sight"))

(defmethod jump-scare :ghost
  [_]
  (js/console.log (str (pad-right "B" 5 "O") "!") "it bemoans menacingly"))


(defmethod jump-scare :spider
  [_]
  (js/console.log "It's a huge one and looks venomous!"))

(defn ^:dev/after-load main
  []
  (let [room (ask-room)
        monster (get monsters room)]
    (js/console.log "You entered the" (room-name room))
    (js/console.log "You see a scary" (name monster))
    (jump-scare monster)
    (js/console.log "You recoil in terror and scream" (-> monster scares scare))))
