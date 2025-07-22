# 🚀 Internet Download Manager

<div align="center">

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Console](https://img.shields.io/badge/Console-Based-4CAF50?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Active-success?style=for-the-badge)

### *A versatile and efficient console-based download manager built in Java*

Streamline your download experience with robust features for handling interrupted downloads, progress tracking, and queue management.

</div>

---

## 📋 **Table of Contents**

- [Features](#-features)
- [Prerequisites](#-prerequisites) 
- [Installation](#-installation)
- [Usage](#-usage)
- [Project Structure](#-project-structure)
- [Technical Implementation](#-technical-implementation)
- [Contributing](#-contributing)
- [License](#-license)

---

## ✨ **Features**

### 🔄 **Resume Capability**
- **Automatic resume** for interrupted downloads
- **Range request support** using HTTP headers
- **File integrity** maintained across sessions

### 📊 **Progress Tracking**
- **Real-time progress** display with percentage
- **Byte-level tracking** of downloaded data
- **Dynamic progress bar** in console

### 📁 **Download Management**
- **Queue-based downloads** for multiple files
- **Custom directory** selection for file storage
- **Flexible file naming** with extension support

### 🛡️ **Error Handling**
- **Connection failure** recovery
- **Invalid URL** validation
- **File permission** error handling

---

## 🔧 **Prerequisites**

- **Java Development Kit (JDK) 8 or higher**
- **Internet connection** for downloading files
- **Write permissions** in the target directory

---

## 📦 **Installation**

1. **Clone the repository:**
git clone https://github.com/SG-Dcoder/Internet_DownloadManager.git
cd Internet_DownloadManager


2. **Compile the Java files:**
javac cn_proj.java

3. **Run the application:**
java cn_proj


---

## 🚀 **Usage**

### **Interactive Mode**

1. **Start the application:**
java cn_proj


2. **Enter download details:**
Enter the file URL: https://example.com/file.zip
Enter the directory to save the file: /path/to/downloads
Enter the file name (including extension): myfile.zip



3. **Monitor progress:**
Downloading: myfile.zip
Progress: 45.67%



### **Example Session**
Enter the file URL: https://releases.ubuntu.com/20.04/ubuntu-20.04.6-desktop-amd64.iso
Enter the directory to save the file: ./downloads
Enter the file name (including extension): ubuntu-desktop.iso

Downloading: ubuntu-desktop.iso
Progress: 100.00%

Download completed!



---

## 📁 **Project Structure**

Internet_DownloadManager/
│
├── cn_proj.java # Main application class
│ ├── main() # Entry point and user interaction
│ └── Input handling # BufferedReader for user input
│
├── Downloadmanager.java # Core download functionality
│ ├── DownloadTask # Inner class for download tasks
│ ├── addDownload() # Queue management
│ ├── startDownloads() # Batch processing
│ ├── downloadFile() # HTTP download logic
│ └── printProgress() # Progress display
│
└── README.md # Project documentation



---

## 🛠️ **Technical Implementation**

### **Core Technologies**
- **Java I/O Streams**: For efficient file handling
- **HttpURLConnection**: For HTTP communication
- **RandomAccessFile**: For resume capability
- **Range Requests**: For partial content retrieval

### **Key Components**

#### **Download Manager**
class Downloadmanager {
private List<DownloadTask> downloadQueue;
// Queue-based download management
}



#### **Resume Logic**
if (file.exists()) {
existingFileSize = file.length();
connection.setRequestProperty("Range", "bytes=" + existingFileSize + "-");
}



#### **Progress Tracking**
private void printProgress(long bytesRead, long totalBytes) {
double progress = (double) bytesRead / totalBytes * 100;
// Real-time progress display
}



### **Performance Features**
- **Buffer Size**: 1024 bytes for optimal performance
- **Memory Efficient**: Stream-based processing
- **Connection Management**: Proper resource cleanup

---

## 🎯 **Use Cases**

- **Large File Downloads**: ISO images, software distributions
- **Unstable Connections**: Resume interrupted downloads
- **Batch Downloads**: Multiple file queue management
- **Educational Projects**: Understanding HTTP protocols
- **Development Tools**: Custom download solutions

---

## 🔮 **Future Enhancements**

- [ ] **Multi-threaded downloads** for faster speeds
- [ ] **GUI interface** using Java Swing/JavaFX
- [ ] **Download scheduling** with time-based triggers
- [ ] **Bandwidth throttling** for network management
- [ ] **Checksum verification** for file integrity
- [ ] **Configuration file** support for settings

---

## 🤝 **Contributing**

Contributions are welcome! Here's how you can help:

1. **Fork the repository**
2. **Create a feature branch**: `git checkout -b feature/AmazingFeature`
3. **Commit changes**: `git commit -m 'Add AmazingFeature'`
4. **Push to branch**: `git push origin feature/AmazingFeature`
5. **Open a Pull Request**

### **Areas for Contribution**
- Performance optimizations
- GUI implementation
- Error handling improvements
- Additional protocol support
- Unit test coverage

---

## 📄 **License**

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.



## 🙏 **Acknowledgments**

- Java documentation for HTTP connection handling
- Open-source community for inspiration
- Stack Overflow for troubleshooting guidance

---

<div align="center">

### ⭐ **If you found this project helpful, please give it a star!**

**Made with ❤️ by [Suraj Ghosh](https://github.com/SG-Dcoder)**

</div>
