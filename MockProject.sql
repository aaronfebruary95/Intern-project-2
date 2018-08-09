CREATE DATABASE MockProject;
USE MockProject;

CREATE TABLE Account (
	AccountID INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	Username VARCHAR(20) UNIQUE NOT NULL,
	[Password] VARCHAR(20) CHECK (LEN(Password) > 0) NOT NULL,
);

CREATE TABLE [Role] (
	AccountID INT NOT NULL,
	[Role] VARCHAR(10) CHECK([Role] IN ('Admin', 'User')),
	FOREIGN KEY (AccountID) REFERENCES Account(AccountID),
);

CREATE TABLE UserInformation (
	AccountID INT NOT NULL,
	FullName VARCHAR(50) NOT NULL,
	Gender VARCHAR(10) CHECK(Gender IN ('Male', 'Female', 'Other')),
	Age INT,
	[Address] VARCHAR(100),
	PhoneNumber INT,
	FOREIGN KEY (AccountID) REFERENCES Account(AccountID),
);

CREATE TABLE Manufacturer (
	ManufacturerID INT IDENTITY(1,1) PRIMARY KEY,
	ManufacturerName VARCHAR(100) NOT NULL,
	ManufacturerAddress VARCHAR(100),
);

CREATE TABLE Category (
	CategoryID INT IDENTITY(1,1) PRIMARY KEY,
	CategoryName VARCHAR(100) NOT NULL,
);

CREATE TABLE Product (
	ProductID INT IDENTITY(1,1) PRIMARY KEY,
	ManufacturerID INT NOT NULL,
	CategoryID INT NOT NULL,
	ProductName VARCHAR(100) UNIQUE NOT NULL,
	Price MONEY,
	Color VARCHAR(50),
	[Description] VARCHAR(100),
	[Availability] BIT, 
	Discount FLOAT NOT NULL CHECK (Discount >= 0 AND Discount < 1),
	FOREIGN KEY (ManufacturerID) REFERENCES Manufacturer(ManufacturerID),
	FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID),
);

CREATE TABLE Shipper (
	ShipperID INT IDENTITY(1,1) PRIMARY KEY,
	CompanyName VARCHAR(100) NOT NULL,
);

CREATE TABLE ShipOrder (
	ShipOrderID INT IDENTITY(1,1) PRIMARY KEY,
	ShipDate DATE NOT NULL,
	ShipperID INT NOT NULL,
	FOREIGN KEY (ShipperID) REFERENCES Shipper(ShipperID),
);

CREATE TABLE Cart (
	CartID INT IDENTITY(1,1) PRIMARY KEY,
	AccountID INT NOT NULL,
	FOREIGN KEY (AccountID) REFERENCES Account(AccountID),
);

CREATE TABLE ProductInCart (
	CartID INT NOT NULL,
	ProductID INT NOT NULL,
	Quantity INT NOT NULL,
	FOREIGN KEY (CartID) REFERENCES Cart(CartID),
	FOREIGN KEY (ProductID) REFERENCES Product(ProductID),
);

CREATE TABLE [Order] (
	OrderID INT IDENTITY(1,1) PRIMARY KEY,
	CartID INT UNIQUE NOT NULL,
	PaymentMethod VARCHAR(50) NOT NULL,
	ShipOrderID INT,
	FOREIGN KEY (CartID) REFERENCES Cart(CartID),
	FOREIGN KEY (ShipOrderID) REFERENCES ShipOrder(ShipOrderID),
);

INSERT INTO Account VALUES 
--Account(UserName, Password)
('guest1', '123456'),
('guest2', '123456'),
('guest3', '123456'),
('guest4', '123456'),
('guest5', '123456');

INSERT INTO Account VALUES ('test', 'test123')

INSERT INTO [Role] VALUES 
--Role(AccountID, Role)
(1, 'Admin'),
(3, 'Admin'),
(2, 'User'),
(4, 'User'),
(5, 'User');

INSERT INTO UserInformation(AccountID, FullName) VALUES 
--UserInformation(AccountID, FullName)
(1, 'Maria Anders'),
(2, 'Renate Messner'),
(3, 'Jose Pavarotti'),
(4, 'Miguel Angel Paolino'),
(5, 'Rene Phillips');

INSERT INTO Manufacturer VALUES
--Manufacturer(ManufacturerName, ManufacturerAddress)
('Samsung', 'Somewhere'),
('Apple', 'Somewhere else'),
('Oppo', 'Trashcan');

INSERT INTO Category VALUES 
('Smartphone'),
('Stupidphone'),
('Smartwatch'),
('Tab');

INSERT INTO Product VALUES
--Product(ManufacturerID, CategoryID, ProductName, Price, Color, Description, Availability, Discount)
(1, 1, 'Samsung Galaxy', 200, 'Black', '', 1, 0),
(2, 1, 'Iphone',  500, 'White', '', 1, 0),
(3, 2, 'Oppo Trash', 10, 'Brown', 'This is very trash', 1, 0.99),
(2, 3, 'IWatch', 300, 'Red', '', 1, 0.2),
(1, 4, 'Samsung Galaxy Tab', 150, NULL, '', 1, 0);

INSERT INTO Cart VALUES
--Cart(AccountID)
(1),
(2),
(3),
(4),
(5),
(1);

INSERT INTO ProductInCart VALUES 
--CartID, ProductID, Quantity)
(1, 4, 2),
(3, 5, 6),
(4, 1, 1),
(5, 3, 1),
(6, 2, 3),
(3, 1, 2),
(3, 2, 2),
(1, 2, 2),
(1, 1, 2),
(1, 5, 2); 

INSERT INTO Shipper VALUES 
('Speedy Express'),
('United Package'),
('Federal Shipping');

INSERT INTO ShipOrder VALUES
--ShipOrder(ShipDate, ShipperID)
(GETDATE(), 1),
(GETDATE(), 2),
(GETDATE(), 3),
(GETDATE(), 1),
(GETDATE(), 2);

INSERT INTO [Order] VALUES 
--Order(CartID, PaymentMethod, ShipOrderID)
(1, 'Cash', 1),
(2, 'Direct', NULL),
(3, 'Transfer', 4);

