# S23_ShapeInheritanceHierarchy_Medium

[Home](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017 "Home")

### Problem Statement
Create a base Shapes class that will have classes that extend to subcategories into more subcategories. There should be three total levels of inheritance. The final level should have at least 6 subclasses. There should be at least 16 shapes to complete a Shape hierarchy. Each object in the Shapes hierarchy should have the ability to have a name assigned to it. The variables and methods should be included to calculate area, volume, surface area, and perimeter. Two additional features should be added to the shape object that may be useful for drawing.

### User Documentation
The program allows the user to create a shape of there desire. The program will ask what of the 16 different shapes they would like to create and the dimensions of the shape and its name. The program will then also calculate the area, volume, perimeter, and surface area depending on the shape being created. The program will also be able to recall all the shapes created and be printed out.

### Developer Documentation
In this Inheritance Hierarchy of Shapes, the main class called **Shapes** will hold the general functionality for what all shapes share in common. It will have the ability to give the shape a name using `setName()`. Also, the number of edges and faces a shape will have can also be set using `setEdges()` and `setFaces()`. Also retrieving the following will be the get methods: `getName()`, `getEdges()`, and `getFaces()`. Edges and Faces are all avaible to all shapes of every dimension and can be used for formulas in drawing the correct number of edges or faces of a shape.

<br>
Shapes are then broken down into two different dimensions from 2 Dimensional to 3 Dimensional shapes. This allows the split between having to calculate the area and perimeter versus volume and surface area.

<br>
In the class called **TwoDimensionalShapes** the area and perimeter can be calculated. Get and Set methods are available under this class so all subclasses that inherit this class will be able to set the area and perimeter of the 2D shape. The following methods are: `setArea()`, `setPerimeter()`, `getArea()`, and `getPerimeter()`.

<br>
The class **ThreeDimensionalShapes** has the ability to calculate the volume and the surface area of the shape. Get and set methods are available under this class so all that inherit this class will be able to set the volume and surface area of the 3D shape. The following methods are: `setVolume()`, `setSurfaceArea()`, `getVolume()`, and `getSurfaceArea()`.

<br>
The classes that inherit **TwoDimensionalShapes** are **NoAngle2DShapes**, **Angle2DEquailateralShapes**, and **RightAngle2DShapes**.

<br>
**NoAngle2DShapes** is a class for shapes that do not have a point of where two edges intersect. Some examples are Ellipses and Circles. These shapes that are rounded will use circumference instead of perimeter in technical terms. The equation for an ellipse for area and circumference will work with a circle. The only difference is that an ellipse is not in equal radius for the horizontal comapared to the vertical axis, while the radius for circles are all equal on each axis. This allows the class **NoAngles2DShapes** to have both axies as varibles because the shapes that inherit this class will have the same equations to calculate the area and perimeter. The methods included `getVerticalRadius()`, `getHorizontialRadius()`, `calcArea()`, `calcPerimeter()`, `setHorizontialRadius()`, and `setVerticalRadius()`.

<br>
**Ellipse** class will use the inherited class **NoAngle2DShapes** to set the Vertical and Horizontial Radii. After use `calcArea()` and `calcPerimeter()` to set those values as well with the Radii set.

<br>
**Circle** class will reuse the Ellipse class but instead it will set the Radii to be equal to each other instead. The calculations for area and perimeter will be the same as the Ellipse from the inherited class **NoAngle2DShapes**.

<br>
**Angle2DEquailateralShapes** are shapes that have angles that are not right angles and are regular shapes (sides of the shape are all equal). The perimeter for all reqular shapes are easily calculated by the number of sides times the length of the sides. We therefore can have this class include the side length since all side lengths will be equal and the get and set methods can be used: `getSidelength()` and `setSidelength()`. Since the perimeter equation is the same for all regular angled shapes the `calcPerimeter()` can be called when the sidelength is set with the number of edges (sides) the shape has. Where each shape under this class will need to set the number of sides (edges) it has by calling the inherited method from the **Shapes** class by calling `setEdges()`.
Each of the shapes under this class **Angle2DEquailateralShapes** will have its own `calcArea()` for each individual shape since all formulas are not universial.

<br>
**RightAngle2DShapes** is a class for shapes that use only right angles. These would include rectangles and squares. All these shapes only include 4 sides since they all have only right angles. These also have equal sides in pairs from the horizontial direction or vertical direction. These are also called the base and the height. The following methods are avalible: `getBase()`, `getHeight()`, `setBase()`, `setHeight()`, `calcPerimeter()`, and `calcArea()`. These calculations on the rectangle can also be used on a square, but a square will have equal sides on the base and height. This allows the use of the area and perimeter to be univeral to right angled shapes with area being the base times the height and perimeter will add the two times the height plus two times the base.

<br>
**Rectangle** is a class that will utilize all of the **RightAngle2DShapes** inherited methods to set its base and height and then calculate the area and perimeter to be set.

<br>
**Square** is a class that will utilize the inherited class **Rectangle** but instead it will set the base and height to be equal to each other.

<br>
Under the **ThreeDimensionalShapes** these categories are also applied but to the bases of the 3D shape instead. The 3D shapes will use surface area and volume instead so these can also be called by its set and get methods from this class. `setSurfaceArea()`, `setVolume()`, `getSurfaceArea()`, and `setVolume()`.

<br>
The subclasses that inherit the **ThreeDimensionalShapes** class will be the same or similar to **TwoDimensionalShapes**. It will contain subclasses of **NoAngleBase3DShapes** and **AngleBase3DShapes**.

<br>
**NoAngleBase3DShapes** is for shapes that have a rounded base where the formulas for surface area and volume use a radius. All shapes that inherit this will set the radius using `setRadius()` and will be able to get the radius with `getRadius()`. Anything else needed like height for cones and cyliners will need to have there own variable. All these 3D shapes will have different formulas for surface area and volume and are not relatable to each other.

<br>
**AngleBase3DShapes** is for shapes that have angled bases that use edge lengths for its surface area and volume formula. To make it simple all shapes will be also regular as well meaning all edges will use equal length. This will allow this class to have the varaible and the get and set methods for edge length. All shapes in this class will need there own Volume and Surface Area formulas since they are not relatable to each other.

ex. `setEdgeLength()` and `getEdgeLength()`

### UML Diagram

![S23_ShapeInheritanceHierarchy_Medium](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/blob/master/S23_ShapeInheritanceHierarchy_Medium/doc/S23_ShapeInheritanceHierarchy_Medium_UML.png)

### [JavaDocs](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/tree/master/S23_ShapeInheritanceHierarchy_Medium/doc)

### [Source Code](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/tree/master/S23_ShapeInheritanceHierarchy_Medium/src)
