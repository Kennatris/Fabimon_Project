# Fabimon

**2D-Rollenspiel · Teamprojekt im Abitur · TGI12 / 2023**

Ein Java-Spiel mit eigener Tile-Welt, Fabimon-Team und rundenbasierten Kämpfen. Das Projekt verbindet Bewegung und NPC-Begegnungen mit Attacken, Charakterwerten, Items und Spielständen.

![Fabimon – rundenbasierter Kampf](docs/media/12-kampf-aufnahmeversion.jpg)

[Projekt und Technik](docs/PROJEKT.md) · [Bildergalerie](docs/GALERIE.md) · [Quellcode herunterladen](https://github.com/Kennatris/Fabimon_Project/archive/refs/heads/master.zip)

## Einblick

| Arena | Attackenauswahl |
| --- | --- |
| ![Arena und Kartenwechsel](docs/media/17-arena-aufnahmeversion.jpg) | ![Attackenauswahl im Kampf](docs/media/13-attackenauswahl-aufnahmeversion.jpg) |

| Trainerbegegnung | Teamwechsel |
| --- | --- |
| ![Trainer-Cutscene](docs/media/16-trainerbegegnung-aufnahmeversion.jpg) | ![Teamwechsel im Kampf](docs/media/14-teamwechsel-aufnahmeversion.jpg) |

Die ausgewählten Spielszenen wurden mit eingefrorener Zeit und gezielt gesetzten Positionen in einer getrennten lokalen Aufnahmeversion festgehalten. Darstellung und Grafiken stammen aus dem historischen Spiel. [Weitere Aufnahmen und Herkunft](docs/GALERIE.md).

## Was umgesetzt wurde

- Tile-basierte Welt mit Kamera, Kollisionen, NPCs und Kartenwechseln.
- Rundenbasiertes Kampfsystem mit Attacken, Werten und Teamwechsel.
- Teamübersicht, Statusseite und Inventar mit Heilitems.
- Drei auswählbare Spielstände sowie Video- und Soundeinstellungen.

![Technikübersicht: Java, Swing/AWT, Spielsysteme und Ressourcen](docs/media/technik.svg)

## Start und Bedienung

Die Anleitung zum Kompilieren und Starten steht in der [Projektdokumentation](docs/PROJEKT.md#kompilieren-und-starten). Java-Klassen und Ressourcen müssen gemeinsam verfügbar sein; das Arbeitsverzeichnis ist der Projektordner.

| Eingabe | Aktion |
| --- | --- |
| W/A/S/D oder Pfeiltasten | Bewegung und Menüauswahl |
| Enter oder Leertaste | Bestätigen und NPC-Interaktion |
| Escape | Pause bzw. zurück |

## Historischer Stand

Die Darstellung basiert auf dem umfangreichsten erhaltenen Abschlussstand vom 21. Juni 2023, Commit `8703abc` aus `PhilippKamerlocher`. Die historischen Teambranches bleiben erhalten; `old/master` bewahrt den bisherigen Hauptstand. [Versionsvergleich und Projektaufbau](docs/PROJEKT.md#historie-und-versionsauswahl).

> Diese rückblickende Dokumentation wurde automatisiert durch einen Agenten erstellt. Der historische Spielquellcode wurde für die Aufbereitung unverändert übernommen. Texte, Technikübersicht und echte Aufnahmen dienen der Veranschaulichung des damaligen Teamprojekts. Alle Angaben und Downloads ohne Gewähr.
