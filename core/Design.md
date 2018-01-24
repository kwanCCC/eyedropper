## Something 

### off-heap index manager

- Design List
```
base on off-heap    
©¦
©¸©¤©¤©¤allocate a memory block that contains all the entry had been serialized
©¦  ©¦
©¦  ©¸©¤©¤©¤ head ==> ||||||||||||||||||||||||||||||| ==> tail
©¦
©¦  
©¸©¤©¤©¤allocate some memory shard and the index are managered by heap
```