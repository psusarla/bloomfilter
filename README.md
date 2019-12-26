# Getting Started
SampleApplication.java illustrates a sample usage of the Bloom Filter. It has a main method and can be executed.

# Classes
## BloomFilter class 
This is the main class, it takes two parameters in the constructor:
1) An implementation of **HashFunction**
2) Size of the bitmap 

During the class instantiation, it reads the wordlist line by line and populates its bitmap. <br/>Wordlist.txt is available at the root project for convenience

## com.msft.hash package 
This package contains a HashFunction interface and its two implementations:
* DefaultHashFunction <br/>Uses JDK's implementation of HashFunction 
* ApacheHashFunction <br/>Uses Apache's implementation of HashFunction
    
# Running the tests
There are 3 unit tests in the project, built using JUnit

* TestBloomFilter is a basic unit test for the BloomFilter. It also tests the DefaultHashFunction.
* TestApacheHashFunction tests the ApacheHashFunction
* TestBitMapSizes tests BloomFilter with different bitmap sizes. 
As we can see, the bigger the bitmap, the accurate the spellCheck function is.

# References
http://codekata.com/kata/kata05-bloom-filters/<br/>
https://stackoverflow.com/questions/15518418/whats-behind-the-hashcode-method-for-string-in-java<br/>
https://www.baeldung.com/java-random-string
