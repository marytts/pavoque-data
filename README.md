# PAVOQUE Corpus of Expressive Speech

## Corpus design

A single speaker, multi-style corpus of German speech, with a large neutral subset, and subsets acting out four different expressive speaking styles, named for virtual characters in the [SEMAINE](http://www.semaine-project.eu/) and [IDEAS4GAMES](http://www.dfki.de/lt/iprojects/ideas4games.php) projects (quoting the original directors instructions):

* **Poppy** ist fröhlich, optimistisch und sieht das Gute an allen Dingen!
(*Poppy is cheerful and optimistic.*)

* **Obadiah** ist von Natur aus niedergeschlagen und blickt pessimistisch in die Zukunft...
(*Obadiah is gloomy and pessimistic.*)

* **Spike** ist aggressiv und geht keinem Streit aus dem Weg!
(*Spike is aggressive and confrontational.*)

* Max ist ein ausgekochter **Poker**spieler. Er ist cool, ihn bringt nichts aus der Ruhe.
(*Max is a hard-boiled poker player. He is cool and laid-back.*)

The speaker is [Stefan Röttig](http://stefan-roettig.de/), a male native speaker of German trained as a professional actor and baritone opera singer.

## Data format

### Audio

The audio data is provided in the losslessly compressed [FLAC](https://xiph.org/flac/) format, which can be played by a [myriad of software](https://xiph.org/flac/links.html#software), including [Praat](http://praat.org/).
The speaker was recorded at a 44.1 kHz sampling rate, 24 bits per sample, in mono.
No filters of any sort have been applied to this raw data, but low-pass filtering at 50 Hz is recommended.

### Phonetic segmentation

The manually corrected phonetic labels are provided as Xwaves `.lab` files;
each line (after the header) has the fields

    [ENDTIME] [NUMBER] [LABEL]

where `ENDTIME` is in seconds, `NUMBER` has no significance, and `LABEL` uses a variant of the [SAMPA](http://www.phon.ucl.ac.uk/home/sampa/) phonetic alphabet.
(These files can also be opened in Praat using the command "Read IntervalTier from Xwaves...".)

## Downloading the corpus

### Git and git-annex

The best way of downloading the PAVOQUE data is to use [**Git**](http://git-scm.com/).
To make the most of the features offered by GitHub, you should [**fork**](https://github.com/marytts/pavoque-data/fork) this repository to your own GitHub account, then use your favorite Git client to **clone** that repo to your local machine.
Please refer to [GitHub Help](https://help.github.com/) and [the Web](http://google.com/) as required.

Because Git is not designed to efficiently handle large amounts of binary data, specifically the audio files in the PAVOQUE corpus, we *manage* those files using [**git-annex**](http://git-annex.branchable.com/).
This means that the actual audio files are not stored in this repo, but we nevertheless leverage the benefits of distributed revision control by tracking which **Git remotes** *do* have copies of the audio files.
However, git-annex also performs poorly with *many* files, so the `.flac` files have been packaged into [tarballs](http://en.wikipedia.org/wiki/Tar_%28computing%29), one per speaking style.
(Use `tar` or your favorite file archive utility to unpack.)

**You will need git-annex** to handle this elegantly.

Once you've cloned the repository, you can use the command `git annex get FILE` to get `FILE`, i.e. one or more of the `tar` files containing the audio recordings.

### Alternative: Git-less download

If all of that stuff about Git and version control is just too technical, you can still download the PAVOQUE corpus in a few simple steps.

1. Download the most recent version (the *master branch*) of this repository as a `.zip` file by clicking on the "Download ZIP" button, or the following URL:

    <https://github.com/marytts/pavoque-data/archive/master.zip>

2. Download the audio data directly from one of the web remotes, such as

    <http://mary.dfki.de/download/pavoque-data/Recordings/>

## License

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/3.0/">
  <img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by-nc-sa/3.0/88x31.png" />
</a>
<br />
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/3.0/">Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License</a>.

## Contact

In case of issues, please open a [new issue](https://github.com/marytts/pavoque-data/issues/new) right here in this repository on GitHub.
If this does not resolve your issue, you may send an email to `ingmar.steiner(at)dfki.de`.
