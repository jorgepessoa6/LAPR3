# Analysis OO #

The process of constructing the domain model is based on the use cases, especially the nouns used, and on the description of the assignment.

## Rational for identifying domain classes ##

For the identification of domain classes is used one list of categories. As a result we have the following table of concepts (or classes, but not software) by category.

### _Categories List_ ###

**Transactions (of business)**

* Trip 

---

**Lines of transactions**

* Invoice

---

**Products or services related to transactions**

*  Trip

---


**Registers (of transactions)**

* Invoice

---  


**People's roles**

* Administrative
* User

---


**Places**

*  Park
*  Points of interest

---

**Events**

* 

---


**Physical objects**

* 


---


**Specifications and descriptions**

*  

---


**Catalogs**

*  

---


**Sets**

*  

---


**Elements of Sets**

*  

---


**Organizations**

*  Company

---

**Other systems (external)**

*  

---


**Registers (financial), work, contracts, legal documents**

* 

---


**Financial instruments**

*  

---


**Referred documents / to perform the tasks**

* 

---



**Rationale on identifying associations between classes**

An association is a relationship between instances of objects that indicates a relevant connection that is worth remembering, or is derivable from the List of Common Associations:

+ A is physically (or logically) part of B
+ A is physically (or logically) contained in B
+ A is a description of B
+ A is known / captured / registered by B
+ A use or generate B
+ A is related with a transaction of B
+ etc



| Concept (A) 		|  Association   		|  Concept (B) |
|----------	   		|:-------------:		|------:       |
|Administrator|specific|Park|
||specific|Vehicle|
|Park|has|Vehicle|
|Vehicle|is|Bicycle|
||is|Scooter|
|Trip|has|Invoice|
||includes|Park|
||has|Vehicle|
||has|Path|
|Path|has|Points Of Interest|
|User|request|Trip|
||rent|Vehicle|

## Domain Model

![MD.png](MD.png)