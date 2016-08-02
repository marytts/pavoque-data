# PAVOQUE Corpus of Expressive Speech

## Corpus design

A single speaker, multi-style corpus of German speech, with a large neutral subset, and subsets acting out four different expressive speaking styles, named for virtual characters in the [SEMAINE](http://www.semaine-project.eu/) and [IDEAS4GAMES](http://www.dfki.de/lt/iprojects/ideas4games.php) projects (quoting the original directors instructions):
- **Poppy** ist fröhlich, optimistisch und sieht das Gute an allen Dingen!
(*Poppy is cheerful and optimistic.*)
- **Obadiah** ist von Natur aus niedergeschlagen und blickt pessimistisch in die Zukunft...
(*Obadiah is gloomy and pessimistic.*)
- **Spike** ist aggressiv und geht keinem Streit aus dem Weg!
(*Spike is aggressive and confrontational.*)
- Max ist ein ausgekochter **Poker**spieler. Er ist cool, ihn bringt nichts aus der Ruhe.
(*Max is a hard-boiled poker player. He is cool and laid-back.*)

The speaker is [Stefan Röttig](http://stefan-roettig.de/), a male native speaker of German trained as a professional actor and baritone opera singer.

## Data format

### Audio

The audio data is provided in the losslessly compressed [FLAC](https://xiph.org/flac/) format, which can be played by a [myriad of software](https://xiph.org/flac/links.html#software), including [Praat](http://praat.org/).
It is sampled at a a rate of 44.1 kHz, with 16 bits per sample, in mono.
No filters of any sort have been applied to this raw data, and low-pass filtering at 50 Hz is recommended.

### Phonetic segmentation

Annotations are provided as one [YAML](http://yaml.org/) file per style.
These files are lists of utterances, each of which contains
- a **prompt** code (file basename),
- the utterance **text**,
- the speaking **style**,
- utterance **start** and **end** times (in seconds) in the FLAC file,
- optionally, the (manually corrected) phonetic **segments**, each of which has
    - a **lab**el (based on [SAMPA](http://www.phon.ucl.ac.uk/home/sampa/german.htm), `_` denotes silence), and
    - its **end** time (in seconds), _relative to that utterance's **start** time_

For example,
```yaml
- prompt: spike0008
  text: Ach ja?
  style: angry
  start: 27.0
  end: 28.92
  segments:
  - {lab: H#, end: 0.280902}
  - {lab: '?', end: 0.324898}
  - {lab: a, end: 0.408238}
  - {lab: x, end: 0.475}
  - {lab: j, end: 0.61}
  - {lab: 'a:', end: 0.963273}
  - {lab: _, end: 1.915}
```

## Downloading the data

Use the links on the [releases](https://github.com/marytts/pavoque-data/releases) page, or run the `download` task (see below).

## Converting the data

For convenience, the utterances for each subset can be be extracted from the YAML and FLAC files using simple commands to run [Gradle](https://gradle.org/) tasks.
After cloning or downloading and unpacking this repository, run `./gradlew tasks` (or `gradlew tasks` on Windows) for details.

### Prerequisites

You will need [Java](https://www.java.com/) to run the Gradle tasks. Extracting the utterances to WAV files also requires [`sox`](http://sox.sourceforge.net/) to be installed.

### Copyright and license

Copyright 2009 [DFKI GmbH](http://dfki.de/).

[![Creative Commons License](http://mirrors.creativecommons.org/presskit/buttons/88x31/svg/by-nc-sa.svg)](http://creativecommons.org/licenses/by-nc-sa/4.0/)

This work is licensed under a [Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License](http://creativecommons.org/licenses/by-nc-sa/4.0/).

## Contact

In case of issues, please open a [new issue](https://github.com/marytts/pavoque-data/issues/new).
