# KasirCLi

Sistem kasir berbasis CLi

<br>

## Fitur

- [x] penyimpanan local
- [x] computasi pentotalan barang yang di beli
- [ ] I/O berbasis cli dan mungkin akan di simpan di file.txt

<br>

## cara pakai

- Call Command
  ```bash
  ~$ ksr
  ```
- untuk memanggil option 
  ```bash
  ~$ ksr start
  ```
- untuk memanggil insert data from csv 
  ```bash
  ~$ ksr insert  
  ```

<br>

## Struktur app
  ```
  src
   ├───main
   └───java
       └───com
           └───kasircli
               ├───controllers
               ├───helpers
               ├───models
               │   └───dto
               ├───services
               └───utils
  ```
## alur kerja
![](documentation/uml/alur%20kerja.png)