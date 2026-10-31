# Fabimon – Projekt und Technik

## Entstehung

Fabimon entstand 2023 als Teamprojekt im Abitur (TGI12). Die erhaltenen Arbeitsbranches tragen die Namen der beteiligten Teammitglieder. Dieses Porträt beschreibt den gemeinsamen Projektumfang; es ordnet keine Funktionen ohne Beleg einzelnen Personen zu.

## Spielidee und Umfang

Die Spielfigur bewegt sich durch eine Tile-Welt und begegnet NPCs und Trainern. Ein Team aus Fabimon besitzt Lebenspunkte, Level, Werte und Attacken. Das Kampfsystem verwaltet eigene und gegnerische Aktionen, Teamwechsel und Items. Spielwelt, Kampf, Dialog, Heilung, Pause, Inventar und Teamansicht werden als unterschiedliche Zustände dargestellt.

Die Bildauswahl in der [README](../README.md) zeigt einen kurzen Einblick. Die [Galerie](GALERIE.md) enthält die aufgenommenen Ansichten einschließlich Menüs und Teamdetails.

## Architektur

![Technikübersicht](media/technik.svg)

| Bereich | Umsetzung |
| --- | --- |
| Einstieg und Spielschleife | `src/main/Main.java`, `GameHandler` |
| Fenster und Darstellung | Swing-Fenster, AWT/Graphics2D, `UI`, `ImageHandler` |
| Welt und Kollisionen | `tile/TileManager`, `CollisionChecker`, Textkarten |
| Figuren und Begegnungen | `entity/Player`, `NPCTest`, `AssetSetter`, `EventHandler` |
| Fabimon und Kämpfe | `entity/Fabimon`, `Battle/Battle`, einzelne Attackenklassen |
| Gegenstände | `src/Items` mit verschiedenen Heilitem-Klassen |
| Spielstände | `settings/SaveCompiler`, Textdateien unter `res/saves` |
| Eingaben und Audio | Tastatur, vorhandene JInput-Anbindung, Java Sound/WAV |

## Dateien und Ressourcen

Der Abschlussstand enthält **60 Java-Quelldateien**. Grafiken, Musik, Karten, Dialoge, Werte, Attackenlisten und Speicherstände liegen unter `res`. Die eingebundenen JInput-/JUtils-JARs liegen im Projektroot. `Documentation` bewahrt zusätzliche historische Unterlagen; `docs` enthält dieses nachträgliche Projektporträt.

Die Anwendung liest viele Dateien über relative Pfade. Deshalb ist das Arbeitsverzeichnis beim Start der Projektroot. Während des Spiels können Einstellungen und Speicherstände unter `res/saves` geschrieben werden; für eine unveränderte Archivkopie empfiehlt sich eine getrennte Laufkopie.

## Kompilieren und starten

Die unveränderten Quellen wurden für diese Aufbereitung unter Windows mit **Temurin JDK 21.0.13+9** kompiliert und gestartet. Die folgenden PowerShell-Befehle werden im Projektroot ausgeführt; `javac` und `java` müssen aus einem JDK erreichbar sein. Die kompilierten Klassen werden im temporären Verzeichnis abgelegt.

```powershell
$classes = Join-Path ([IO.Path]::GetTempPath()) 'fabimon-classes'
New-Item -ItemType Directory -Force -Path $classes | Out-Null
$sources = @(Get-ChildItem -LiteralPath src -Recurse -Filter *.java | ForEach-Object FullName)
$libs = 'jinput-2.0.9.jar;jutils-1.0.0.jar'
javac -proc:none -encoding UTF-8 -cp $libs -d $classes @sources
java -cp "$classes;res;$libs;jinput-platform-2.0.7-natives-windows.jar" main.Main
```

Im Titelbildschirm zuerst unter **SELECT SAVE** einen vorhandenen Speicherplatz auswählen, über **BACK** zurückkehren und anschließend **LOAD GAME** wählen. Die Aufnahmen verwenden einen mitgelieferten Originalspielstand. Bewegung und Menüauswahl erfolgen mit W/A/S/D oder den Pfeiltasten, Bestätigen und NPC-Interaktion mit Enter oder Leertaste. Escape öffnet die Pause bzw. führt zurück. Das Pausenmenü bietet Inventar und Teamansicht.

## Historie und Versionsauswahl

| Erhaltener Stand | Einordnung |
| --- | --- |
| `old/master` · `330a6df` | Bisheriger Hauptstand; bewahrt die frühere Hauptbranch-Version. |
| `PhilippKamerlocher` · `8703abc` | Abschlusscommit „fertig“ vom 21.06.2023; Grundlage dieser Darstellung. |
| `Kennatris` und `FabioEinhauser` | Frühere Team-Arbeitsstände, weiterhin unverändert erhalten. |

Der Abschlussstand besitzt gegenüber dem früheren Hauptstand unter anderem zusätzliche Itemklassen, Attacken, Bilder und Musik sowie eine erweiterte Team-/Kampfverwaltung. Für die Aufbereitung werden seine historischen Quell- und Ressourcendateien unverändert übernommen. Die neue Dokumentation ist davon getrennt.

## Prüfung und Einordnung

Nachgewiesen sind die Kompilierung aller 60 Quellen und der Start der dokumentierten Oberflächen unter Windows. Die Galerie unterscheidet regulär erreichte Ansichten von gezielt gestellten Aufnahmen mit eingefrorener Zeit; sie ist kein Nachweis für fehlerfreie Funktion sämtlicher Spielabläufe. Die vorhandene Controller-Anbindung wird als historischer Bestandteil beschrieben, ohne eine aktuelle Hardware-Abnahme zu behaupten.

Die ursprünglichen Grafiken, Musikdateien, Bibliotheken und historischen Hinweise bleiben erhalten. Diese Aufbereitung vergibt keine neue pauschale Lizenz für fremde Bestandteile.

> Automatisiert durch einen Agenten erstellte rückblickende Dokumentation. Der historische Spielquellcode wurde für die Veranschaulichung unverändert übernommen. Alle Angaben und Downloads ohne Gewähr.
