### Array

|      C++                                |                  Java                    |             Python          | 
| ----------------------------------------| ---------------------------------------- |-----------------------------|
| vector<int> nums;                       | List<Integer> nums = new ArrayList<>();  |  nums =[]                   |
| nums.insert(nums.begin()+index,value);  | nums.add(index,value);                   |  nums.insert(index,value)   |
|nums.push_back(value);                   | nums.add(value);                         |  nums.append(value)         | 
|unsigned int size = nums.size();         | int size = nums.size();                  |  size = len(nums)           |  
|int head = nums.front();                 | int head = nums.get(0):                  |  head = nums[0];            |
|int value = nums.at(index);              | int value = nums.get(index);             |  value = nums[index]        |    
|int tail = nums.back();                  | int tail = nums.get(nums.size()-1);      |  tail = nums[len(nums)-1]   |    
|for(vector<int>::iterator it=nums.begin();it!=nums.end();it++){ cout<<*it<<endl; }     |for(int i=0;i<nums.size();i++){ System.out.println(nums.get(i); }  |    for val in nums:  print(val)    |
| nums.erase(nums.begin());               | nums.remove(0);                          | nums.pop(0)                 |
| nums.pop_back();                        | nums.remove(nums.size()-1);              | nums.pop()                  |                                                                                               
| nums.erase(nums.begin()+index);         | nums.remove(index);                      | nums.pop(index)             |
| remove(nums.begin(), nums.end(), value);| nums.remove(value);                      | nums.remove(value)          |                                                                                                


### Deque
|      C++                                |                  Java                    |             Python          | 
| ----------------------------------------| ---------------------------------------- |-----------------------------|
|#include &lt;deque>                      | import java.util.ArrayDeque;             |from collections import deque|
|deque&lt;int> dq;                        | Deque<String> deque = new ArrayDeque<>();| dq = deque()                |                                                  |dq.push_front(val);                      | deque.addFirst(val); or deque.offerFirst(val); | dq.appenleft(val)     |                                     
|dq.push_back(val);                       | deque.addLast(val);                       | dq.append(val)             |                                                                                                               
                                                                                                                         





