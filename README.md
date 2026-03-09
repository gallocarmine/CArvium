
![Logo](src/main/webapp/images/white-logo.png)

<div>
  <img src="src/main/webapp/video/home-car.gif" width="800" alt="Race GIF">
</div>

**CArvium** is a *web platform* dedicated to the **luxury automotive** world, designed to provide a **complete** and **intuitive** service.
The website allows users to **easily purchase high-quality spare parts** for premium car models, ensuring **perfect compatibility** and **exceptional quality**.
The project combines **functionality**, **elegant design**, and **innovation** to *enhance the online shopping experience* in the luxury automotive sector,
making it **accessible to enthusiasts and professionals alike**.
> *Your exclusive destination for high-end vehicles*

***(The type of web software (e-commerce)  was constrained by the course.
To ensure a deep understanding of core web principles, the course mandated the use of low-level technologies,
specifically requiring raw Servlets instead of high-level frameworks.)***

<br>

# 📁 *Index*

- [Demo](#-demo)
- [Software Stack](#software-stack)
- [Features & System](#-features--system)
- [Installation](#-installation)
- [License](#-license)

--- 

<br>

# 🚀 *Demo*
<div align="center">
  <a href="https://www.youtube.com/watch?v=gy2K0Q0AjhM" target="_blank">
    <img src="https://img.youtube.com/vi/gy2K0Q0AjhM/maxresdefault.jpg" alt=" " width="800"/>
  </a>
</div>

---

<br>


# *Software Stack*

<p align="center">
  <img src="https://img.shields.io/badge/Architecture-3--Tier-00599C?style=for-the-badge&logo=server&logoColor=white" alt="3-Tier Architecture" height="35"/>
  <br><br>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" alt="Java" width="45" height="45"/> &nbsp;&nbsp;
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/javascript/javascript-original.svg" alt="JavaScript" width="45" height="45"/> &nbsp;&nbsp;
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/html5/html5-original.svg" alt="HTML5" width="45" height="45"/> &nbsp;&nbsp;
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/css3/css3-original.svg" alt="CSS3" width="45" height="45"/> &nbsp;&nbsp;
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" alt="MySQL" width="45" height="45"/>
</p>

--- 

<br>


# 🧩 *Features & System*

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

<br>

# 📦 *Installation*

Follow these steps to run **CArvium** locally:

### 1. Prerequisites
- Java JDK 21+
- Apache Tomcat 11
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
Copy the WAR file to Tomcat’s webapps folder and on bin/ folder run:
```bash
./startup.sh
```

Open the application in your browser:
- HTTP (default): http://localhost:8080/gallo_esposito_pj_war/
- HTTPS (if configured): https://localhost:8443/gallo_esposito_pj_war/

___

<br> 

# 📑 *License*
© 2025 Gallo Carmine — All Rights Reserved.  
This project is proprietary and may **not** be copied, modified, or distributed without explicit permission by author.
