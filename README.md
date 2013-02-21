<h1>Section 12 Project 1</h1>

<h2>Overview</h2>

Till now we have been working on a desktop game. However, nowadays a lot of  software development is for web based products. In this project we will build the first version of Minesweeper for the web.

We will use simple technologies like [Servlets](http://www.oracle.com/technetwork/java/index-jsp-135475.html), [JSP](http://www.oracle.com/technetwork/java/javaee/jsp/index.html), Javascript, [JQuery](http://jquery.com/), HTML, and CSS to build this project. Like all the previous exercises, we already have some skeleton code ready for you, such that you have to complete it to get the project to work. We don't have automated test cases for the web based product, but we do have an Acceptance Test Document (ATD) against which you have to manually verify if the project is working as it should.

This project is an Eclipse _Dynamic Web Project_. All the source files are in _Java Resources_, all the web related files such as JSP, CSS, images, JS, etc are in _Web Content_. This folder also contains _WEB-INF_ which in turn contains ```web.xml```. Read through ```web.xml``` to understand how we have defined the welcome file list, and how we have declared the Servlet.

<h2>Steps For This Project</h2>

 1. Run the project, by right clicking on the project and selecting _'Run As->Run on Server'_. If everything went well, you should see a Hello World message. 
 1. Refactor ```game.jsp``` to show an empty grid using the ```table``` HTML tag, for the minesweeper game.
 1. The Javascript code embedded at the bottom of ```game.jsp``` captures left and right clicks on squares in the grid, and makes a request to the Servlet. The Servlet will change the state of the board which should be rendered on game.jsp. Make sure the ```td``` tags that make up the cells in the table have an appropriate ```class``` and ```id```. You should be able to figure out the values by looking at the Javascript code at the bottom of ```game.jsp```.
 1. Ensure that the Servlet properly handles requests that come from the browser and write code in ```game.jsp``` to hange the state of the board appropriately.
 1. While rendering the board on the grid in the browser, every uncovered square which is not a mine, should display the count. Every marked square should have a red background.
 1. When the user uncovers a mine you should display the image _images/mine.jpg_ in that square and freeze the grid, so the user cannot uncover or mark any further squares.
