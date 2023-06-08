## Struktura klas oraz pseudokod
- Nowy projekt maven
- FirstApp w odpowiednim pakiecie
- Klasy - model - ParentProfile, ChildProfile, ArtisticLesson, SportActivity
    - Konstruktory
    - Relacje między nimi
- Pseudokod głównej logiki


## Główna pętla programu oraz komunikacja z użytkownikiem
- Główna pętla programu (zmienna sterująca i obsługa wyjątków)
- UserInputManager, UserInputCommand - szkic
- Implementacja UserInputManager
- Implementacja UserInputCommand
- Wyświetlenie UserInputCommand w głównej pętli


## Testy aplikacji i TDD
- Dodanie JUnit5 do projektu
- Wygenerowanie testu dla UserInputCommand


## Implementacja obsługi komend
- Pusta lista commandHandlerów
- Interfejs CommandHandler
- BaseCommandHandler
- HelpCommandHandler
- QuitCommandHandler
- Dodanie handlerów do listy i obsługa listy
    - optional
    - log nieznany command handler
    - break głównej pętli


## Komunikacja z systemem plików oraz utrwalenie danych
- ParentCommandHandler, ChildCommandHandler - szablon
- Zapis do pliku, komunikacja z DAO, ParentDao, ChildDao
- Wypełnienie ParentCommandHandler, ChildCommandHandler
- Child.toString


## Serializacja obiektów
- Copy ParentDao to ChildDao -> problem z serializacją
    - Zależność jackson-databind
    - Refaktor ChildDao z jackson


## Refaktoryzacja kodu
- Wprowadzenie enum Action
    - Refaktor po wprowadzeniu UserInputCommand.action
- ChildCommandHandler
    - Dodanie ChildDao i pobranie listy dzieci
    - Metoda ChildDao.findOne
    - Refaktor ChildDao na jackson
    - Model.Child - default konstruktor dla jackson


## Logi, obsługa wyjątków oraz walidacja danych
- Dodajemy loggery: do wszystkich klas
- validacja parametrów
    - Spróbować wprowadzić niepoprawne dane
    - CategoryCommandHandler walidacja parametrów
    - Główna pętla dodatkowy catch na walidację


## Dalszy rozwój aplikacji
- Brak obsługi spacji
    - W jaki inny sposób oddzielić parametry?
- Przechowywanie danych
    - Rozważyć wprowadzenie bazy danych
- Dao
    - Wynieść wspólne części przed nawias
    - Framework do obsługi danych
- Zaimplementować dodatkowe akje
    - Usuwanie
    - Aktualizacja
- Dodać więcej wyrażeń lambda i strumieni
- Wprowadzenie warstwy webowej

## Błędy do poprawy
- lesson:
  - childList:
    - unknown action
    - funkcja do dodania
