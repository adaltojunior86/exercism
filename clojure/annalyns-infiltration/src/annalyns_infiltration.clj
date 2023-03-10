(ns annalyns-infiltration)

(defn can-fast-attack?
  "Returns true if a fast-attack can be made, false otherwise."
  [knight-awake?]
  (not knight-awake?))

(defn can-spy?
  "Returns true if the kidnappers can be spied upon, false otherwise."
  [knight-awake? archer-awake? prisoner-awake?]
  (or knight-awake? archer-awake? prisoner-awake?))

(defn can-signal-prisoner?
  "Returns true if the prisoner can be signalled, false otherwise."
  [archer-awake? prisoner-awake?]
  (and (not archer-awake?) prisoner-awake?))

(defn allPersonsAreSleeping [knight-awake? archer-awake? prisoner-awake?]
  (and
   (not knight-awake?)
   (not archer-awake?)
   (not prisoner-awake?)))

(defn onlyPrisonerIsAwake [knight-awake? archer-awake? prisoner-awake?]
  (and
   (not knight-awake?)
   (not archer-awake?)
   prisoner-awake?))

(defn- onlyArcherSleeping [knight-awake? archer-awake? prisoner-awake?]
  (and
   knight-awake?
   (not archer-awake?)
   prisoner-awake?))

(defn- onlyKnightAwake [knight-awake? archer-awake? prisoner-awake?]
  (and
   knight-awake?
   (not archer-awake?)
   (not prisoner-awake?)))

;; !knightIsAwake && !archerIsAwake && !prisonerIsAwake
(defn can-free-prisoner?
  "Returns true if prisoner can be freed, false otherwise."
  [knight-awake? archer-awake? prisoner-awake? dog-present?]
  (or
   (onlyPrisonerIsAwake knight-awake? archer-awake? prisoner-awake?)
   (and dog-present?
        (or
         (allPersonsAreSleeping knight-awake? archer-awake? prisoner-awake?)
         (onlyArcherSleeping knight-awake? archer-awake? prisoner-awake?)
         (onlyKnightAwake knight-awake? archer-awake? prisoner-awake?)))))
