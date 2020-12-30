;;================================================================================================= 
;; Path planning analysis into a domain and a problem:
;;
;; There is 1 dock, which has 3 locations (piers),in which there are piles of containers.
;; Each location can hold infinite number of piles of containers.
;; The locations are connected with two-way roads, for the robot to move from one to another.
;; Location1 is connected with Location2 and Location3. Location2 is not connected with Location3.
;; Each location can accomodate only 1 robot.
;; The robot has an integrated crane on it, which can hold 1 container on the robot's platform.
;; The crane can also stack a container on top of another.
;; 
;; Initial state:
;; -Robot at Location2.
;; -Container2 at Location2.
;; -Container1 and Container3 at Location1.
;; -Container3 on top of Container1.
;; 
;; Goal: 
;; -Robot at Location1.
;; -Container1 and Container2 and Container3 at Location3.
;; -Container1 on top of Container2.
;; -Container3 on the floor.
;;================================================================================================= 
(define (domain dock-robot-crane-piers-containers)
 (:requirements :strips :typing )

 (:predicates
    (ROBOT ?R)                  ; True if R is a robot.
    (CRANE ?K)                  ; True if K is a crane.
    (LOCATION ?L)               ; True if L is a location.
    (CONTAINER ?C)              ; True if C is a container.
    (AT_ROBBY ?L)               ; True if L is a location and robot is in L.
    (LOCATED_CONTAINER ?C ?L)   ; True if C is a container, L is a location and C is in L.
    (BELONGS ?K ?R)             ; True if K is a crane, R is a robot and K belongs to R.
    (FREE ?K)                   ; True if K is a crane and carries nothing.
    (CARRY ?K ?C)               ; True if K is a crane, C is a container and K carries C.
    (ON ?C1 ?C2)                ; True if C1 is a container, C2 is a container and C1 is on C2.
    (ADJACENT ?L1 ?L2)          ; True if L1,L2 y are adjacent locations.
    (FLOOR ?C)                  ; True if C is a container and C is on the floor.
    (EMPTY_TOP ?C)              ; True if C is a container and C has nothing on top of it.
   )

;; moves a robot between two adjacent locations
 (:action move                           
     :parameters (?R ?FIRST-LOCATION ?SECOND-LOCATION)
     :precondition (and (ROBOT ?R) (LOCATION ?FIRST-LOCATION) (LOCATION ?SECOND-LOCATION) (AT_ROBBY ?FIRST-LOCATION) (ADJACENT ?FIRST-LOCATION ?SECOND-LOCATION))
     :effect (and (AT_ROBBY ?SECOND-LOCATION) (not (AT_ROBBY ?FIRST-LOCATION)) )
 )
;; the robot picks a container from the current location's floor and carries it via the crane. 
 (:action pick_from_floor_and_carry                               
     :parameters ( ?R ?K ?C ?L )
     :precondition (and (ROBOT ?R) (CONTAINER ?C) (LOCATION ?L) (CRANE ?K) (BELONGS ?K ?R) (FREE ?K) (AT_ROBBY ?L) (LOCATED_CONTAINER ?C ?L) (FLOOR ?C) (EMPTY_TOP ?C))
     :effect (and (CARRY ?K ?C) (not (LOCATED_CONTAINER ?C ?L)) (not (FREE ?K)) (not(EMPTY_TOP ?C)) )
  )   
;; the robot drops a container from it's crane to the floor of a location.
 (:action drop_from_crane_and_place_on_floor                    
     :parameters ( ?R ?K ?C ?L )
     :precondition (and (ROBOT ?R) (CONTAINER ?C) (LOCATION ?L) (CRANE ?K) (BELONGS ?K ?R) (AT_ROBBY ?L) (CARRY ?K ?C))
     :effect (and (FLOOR ?C) (EMPTY_TOP ?C) (LOCATED_CONTAINER ?C ?L) (FREE ?K) (not (CARRY ?K ?C)) )
 )    
;; the robot picks a container from the current location's floor and places it on top of another container in the same location. 
 (:action pick_from_floor_and_place_above_another                               
     :parameters ( ?R ?K ?C1 ?C2 ?L )
     :precondition (and (ROBOT ?R) (CONTAINER ?C1) (CONTAINER ?C2) (LOCATION ?L) (CRANE ?K) (BELONGS ?K ?R) (FREE ?K) (AT_ROBBY ?L) (EMPTY_TOP ?C1)
                        (LOCATED_CONTAINER ?C1 ?L) (LOCATED_CONTAINER ?C2 ?L) (FLOOR ?C1) (EMPTY_TOP ?C2))
     :effect (and (ON ?C1 ?C2) (not (EMPTY_TOP ?C2)) (not(FLOOR ?C1)) )
 )
;; the robot picks a container from the top of a pile in a certain location. 
 (:action pick_from_pile_and_place_on_floor                               
     :parameters ( ?R ?K ?C1 ?C2 ?L )
     :precondition (and (ROBOT ?R) (CONTAINER ?C1) (CONTAINER ?C2) (LOCATION ?L) (CRANE ?K) (BELONGS ?K ?R) (FREE ?K) (AT_ROBBY ?L) 
                        (LOCATED_CONTAINER ?C1 ?L) (LOCATED_CONTAINER ?C2 ?L) (ON ?C1 ?C2) (EMPTY_TOP ?C1))
     :effect (and (FLOOR ?C1) (EMPTY_TOP ?C2) (not (ON ?C1 ?C2)) )
 )
 )