# Worttrainer

## Dependencies

* Jdk21
* gradle

## Installation
```bash
# Clone Project
git clone https://github.com/TGM-HIT/sew9-2425-worttrainer-jscarlataS.git
cd sew9-2425-worttrainer-jscarlataS

# Build jar
gradle clean build

# Run jar
java -jar app/build/libs/app-1.0-SNAPSHOT.jar
```

## Usage

After launching the jar file, a window will appear displaying an image of either a dog or a cat.  
In the provided text field, type "Cat" or "Dog" based on the image shown.  
At the bottom left, you'll find statistics showing the total number of inputs and the number of correct entries.  
To add a new word, enter the following format in the text field: `wordYouWantToAdd, directLinkToImage` and press the 
"Add Word" button.
