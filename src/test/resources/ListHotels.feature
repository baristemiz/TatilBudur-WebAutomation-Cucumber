@ListHotels
  Feature: Oda ve uçak listeleme
    Misafir kullanıcı olarak web sitesini açıp
    Antalya'dan 7 günlük tatil arayıp
    En ucuz odayı seçip fiyat listeleyip
    Kalkış ve varış havalimanı Sabiha Gökçen seçip
    Uçuş listesini görüntülemek istiyorum.

  Scenario: Oda ve uçak listele
    Given TatilBudur web sitesi açılır
    When Antalya kelimesi arama kısmına girilir
    And Başlangıç tarihi 1 Ağustos seçilir
    And Bitiş tarihi 8 ağustos seçilir
    And Arama tuşuna basılır
    And Sonuçlarda en üstte çıkan oda seçilir ve detay sayfasına geçilir
    And Detay sayfasında en üstteki oda seçilir ve ödeme sayfasına geçilir
    And Ulaşım ister misiniz alanına İstiyorum seçeneği işaretlenir
    And Kalkış havalimanına Sabiha Gokcen yazılır
    And Varış havalimanına Sabiha Gokcen yazılır
    Then Ara butonuna basılır ve uçaklar listelenir