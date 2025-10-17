
![Logo](src/main/webapp/images/white-logo.png)

**CArvium** is a *web platform* dedicated to the **luxury automotive** world, designed to provide a **complete** and **intuitive** service.
The website allows users to **easily purchase high-quality spare parts** for premium car models, ensuring **perfect compatibility** and **exceptional quality**.
The project combines **functionality**, **elegant design**, and **innovation** to *enhance the online shopping experience* in the luxury automotive sector,
making it **accessible to enthusiasts and professionals alike**.
> *Your exclusive destination for high-end vehicles*


***(The type of web software (e-commerce) was constrained by the course)***

---

# 📁 Index

 1.[Demo](#-demo)  
 2.[Software Stack & My Contributions](#software-stack--my-contributions)  
 3.[Features & System](#-features--system)  
 4.[Installation](#-installation)  
 5.[License](#-license)

---

# 🚀 Demo
<div align="center">
  <a href="https://www.youtube.com/watch?v=gy2K0Q0AjhM" target="_blank">
    <img src="https://img.youtube.com/vi/gy2K0Q0AjhM/maxresdefault.jpg" alt=" " width="800"/>
  </a>
</div>

---

# Software Stack & My contributions

**Architecture**: MVC  
**Backend**: Java  
**Frontend**: JSP, Javascript, HTML, CSS  
**Database**: MySQL  

 [![CodeTime Badge](https://shields.jannchie.com/endpoint?style=for-the-badge&color=&url=https%3A%2F%2Fapi.codetime.dev%2Fv3%2Fusers%2Fshield%3Fuid%3D33409%26project%3Dgallo-esposito_pj%26language%3Djava)](https://codetime.dev)
 [![CodeTime Badge](https://shields.jannchie.com/endpoint?style=for-the-badge&color=blue&url=https%3A%2F%2Fapi.codetime.dev%2Fv3%2Fusers%2Fshield%3Fuid%3D33409%26project%3Dgallo-esposito_pj%26language%3Djavascript)](https://codetime.dev)  
 [![CodeTime Badge](https://shields.jannchie.com/endpoint?style=for-the-badge&color=blue&url=https%3A%2F%2Fapi.codetime.dev%2Fv3%2Fusers%2Fshield%3Fuid%3D33409%26project%3Dgallo-esposito_pj%26language%3Djsp)](https://codetime.dev)
 [![CodeTime Badge](https://shields.jannchie.com/endpoint?style=for-the-badge&color=blue&url=https%3A%2F%2Fapi.codetime.dev%2Fv3%2Fusers%2Fshield%3Fuid%3D33409%26project%3Dgallo-esposito_pj%26language%3Dcss)](https://codetime.dev)
 [![CodeTime Badge](https://shields.jannchie.com/endpoint?style=for-the-badge&color=blue&url=https%3A%2F%2Fapi.codetime.dev%2Fv3%2Fusers%2Fshield%3Fuid%3D33409%26project%3Dgallo-esposito_pj%26language%3Dsql)](https://codetime.dev)

---

# 🧩 Features & System

### 🔐 **Login / Sign Up**
The system includes a complete **authentication and registration** module that allows users to securely create an account and access the platform.  
Data validation and input control are implemented during registration.  
Once logged in, users can acces reserved sections such as profile management, wishlist, and order history. 

---

### 🛡️ **Security**
The platform is designed with a strong focus on **data and transaction security**, implementing:
- **Password encryption** and secure session management.
- **Client-side and server-side data validation**.
- **Access control** to distinguish between standard users and admins.
---

### 👤 **Profile Management & Order History**
Each authenticated user has access to a personal dashboard where they can:
- **Edit personal information** (name, email, password, address, etc.).
- **View their order history**.
- Access their **wishlist**
---

### 🧭 **Admin Management & Sales Dashboard**
An **admin panel** is available for users with administrative privileges.  
From this area, admins can:
- Monitor **sales performance** through dynamic charts and statistics.
- Analyze performance and **track business trends** to optimize sales.
---

### 🔎 **Smart Search with Filters**
Users can perform advanced searches using a system of **intelligent filters**, allowing them to refine results by:
- Brand
- Model
- Year
- Category or component type  
- Price range (Min - Max)  
The search engine is optimized to **always** deliver **relevant and real-time results**, improving overall navigation efficiency.
---

### ❤️ **Wishlist**
Logged users can **save their favorite cars** from the showroom to a **personal wishlist**.

---

### 🛠️ **Spare Parts Shop**
A dedicated section allows users to **purchase genuine spare parts and accessories** for luxury vehicles.  
Users can filter parts by brand, model, and category price range, and add them to the cart.  
This section ensures a **reliable and comprehensive shopping experience** with original, high-quality components. 

---

### 🛒 **Smart Cart Management**
The shopping cart is designed for an **intuitive and dynamic experience**:
- **Automatic updates** of item quantities **available in real time** and total price.
- **Persistent cart storage**, keeping items saved across sessions.
---

# ⚙️ Installation

Follow these steps to run **CArvium** locally:

### 1. Prerequisites
- Java JDK 21+
- Apache Tomcat 9+ 
- Apache Maven
- MySQL 8+
- Git

### 2. Clone the repository
```bash
git clone https://github.com/gallocarmine/CArvium.git
cd CArvium
```
### 3. Start MySQL and Create a new Database 

Import the database schema and initial data:
```
src/database/scheme.sql;
src/database/data.sql;
```

### 4. Build the project

Use Maven to compile and package the application:
```bash
mvn clean package
```
This will generate a gallo-esposito_pj-1.0-SNAPSHOT.war file in the target/ folder.

### 5. Deploy to Tomcat
Copy the WAR file to Tomcat’s webapps folder OR run directly with Maven:
```bash
mvn tomcat7:run
```

Start Tomcat and open the application in your browser:
- HTTP (default): http://localhost:8080/gallo_esposito_pj_war/
- HTTPS (if configured): https://localhost:8443/gallo_esposito_pj_war/

___

# 📑 License
© 2025 Gallo Carmine — All Rights Reserved.  
This project is proprietary and may **not** be copied, modified, or distributed without explicit permission by author.