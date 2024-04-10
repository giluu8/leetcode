
    // we can use vector (problem with removal bcz random access by value is not possible)
    // we can use set which uses red black tree(prblm with getrandom bcz random access is not possible in this case)
    // we can use DDL(head or tail we have prnlm with removal as well as getrandom )
      
    
    //solution :we need to use MAP[store index/address]
    //use array+hashmap
    
    class RandomizedSet {
        //declare list ,hashmap
        
        List<Integer>list;
      HashMap<Integer,Integer>map;  //<keys,value>
         Random random=new Random();
       
    

    public RandomizedSet() {
        //initialize list ,map
        list=new ArrayList<Integer>();
        map=new HashMap<Integer,Integer>();
        
    }
    
    public boolean insert(int val) {  //time=  o(1)
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,list.size());  //list.size will give index
        list.add(val);
        return true;
        
    }
    
    public boolean remove(int val) {  //ORDER OF 1 TYPE   
        //time=      o(n)
        if(!map.containsKey(val)){
            return false;
        }
        int pos=map.get(val);
        if(pos!=(list.size()-1)){
            int lastElement=list.get(list.size()-1);
            list.set(pos,lastElement);
            map.put(lastElement,pos);
        }
        map.remove(val);
        list.remove(list.size()-1);
        return true;
        
    }
    
    public int getRandom() {  //USE RAND()%SIZE  WHERE SIZE= 0 T0(SIZE-1)
                               // time    o(1)
        int randomInt=random.nextInt(list.size());
        return list.get(randomInt);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */