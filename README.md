# Kütüphane Yönetim Sistemi - REST API

Bu proje, Spring Boot kullanılarak geliştirilmiş bir Kütüphane Yönetim Sistemi REST API uygulamasıdır.  
Kitap, yazar, yayınevi, kategori ve kitap ödünç alma işlemleri için CRUD (Create, Read, Update, Delete) işlemleri sunar.

## Kullanılan Teknolojiler

- Java 21  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Lombok  
- Hibernate Validator  
- IntelliJ IDEA

## Proje Mimarisi

Proje katmanlı bir mimariye sahiptir:

- entity  
- repository  
- service  
- controller  
- dto

## Varlıklar Arası İlişkiler

- Bir yazarın birden fazla kitabı olabilir (One-to-Many)  
- Bir yayınevinin birden fazla kitabı olabilir (One-to-Many)  
- Bir kitap birden fazla kategoriye ait olabilir, bir kategori de birden fazla kitap içerebilir (Many-to-Many)  
- Bir kitap birden fazla kez ödünç alınabilir (One-to-Many)

## Özel İş Kuralları

- **Kategori Silme:**  
  Eğer bir kategoriye ait kitap varsa, silinemez.  
  Yanıt: `"Bu kategoriye ait kitap var. Bu kategori silinemedi."`

- **Kitap Ödünç Alma:**  
  Stok 0 ise, kitap ödünç verilemez.  
  Stok kontrolü yapılır, başarıyla ödünç verilirse stok azaltılır.

## Validasyon

- DTO sınıflarında `jakarta.validation` anotasyonları kullanılmıştır.  
- Zorunlu alanlar: ödünç alan kişi adı, kitap ID’si, ödünç alma tarihi.

## Örnek Endpointler

| Yöntem | Endpoint                          | Açıklama                              |
|--------|-----------------------------------|----------------------------------------|
| GET    | /api/books                        | Tüm kitapları getirir                 |
| POST   | /api/books                        | Yeni kitap ekler                      |
| PUT    | /api/books/{id}                   | Kitap günceller                       |
| DELETE | /api/books/{id}                   | Kitap siler                           |
| GET    | /api/authors                      | Tüm yazarları getirir                 |
| POST   | /api/categories                   | Yeni kategori ekler                   |
| DELETE | /api/categories/{id}              | Kategori siler (kitap ilişkisi kontrolü ile) |
| POST   | /api/borrowings                   | Kitap ödünç alma işlemi (stok kontrolü) |
| PUT    | /api/borrowings/{id}/return       | Kitap iade işlemi                     |
| GET    | /api/publishers                   | Yayınevlerini listeler (adres bilgisi olmadan) |

## DTO Kullanımı

- **Publisher GET** isteklerinde adres bilgisi gösterilmez.  
- **BookBorrowing** işlemlerinde e-mail alanı güncelleme sırasında kullanılmaz.

## Projeyi Çalıştırmak İçin

1. PostgreSQL veritabanını başlatın  
2. `library` isminde bir veritabanı oluşturun  
3. `src/main/resources/application.properties` dosyasını güncelleyin

