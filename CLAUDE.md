# CLAUDE.md — Course Documentation Project (cdp)

## What this project is

A Sphinx/RST static documentation site for Leo Irakliotis' computer science courses at Loyola University Chicago. Source lives in `docs/source/`. Built HTML is output to the repo root. Everything runs on the `gh-pages` branch — source and output coexist on the same branch. GitHub Actions builds on every push to `gh-pages` and auto-commits the HTML output back to the same branch.

**Do not confuse `main` (mostly unused) with `gh-pages` (the working branch).**

## Tech stack

- Python / Sphinx (`sphinx-build -b html docs/source .`)
- Theme: `sphinx_book_theme` (switched from `sphinx_rtd_theme` in commit `4556d81f`)
- Extensions: `sphinxcontrib.gist`, `sphinx.ext.githubpages`, `sphinx.ext.autosectionlabel`
- Dependencies: `requirements.txt` (Sphinx ≥ 7.0, sphinx-book-theme ≥ 1.0, sphinxcontrib-gist)
- CI/CD: `.github/workflows/sphinx.yml` — builds on push to `gh-pages`, also supports `workflow_dispatch` for manual runs

## Project layout

```
docs/source/          ← all RST source files (edit here)
  conf.py             ← Sphinx configuration
  index.rst           ← site root / toctree
  shared/             ← reusable policy/syllabus includes (attendance, grading, DEI, etc.)
  COMP170/            ← course directories (one per course)
  COMP271/
  COMP363/
  COMP460/
  HONR204/
  ... etc.
.github/workflows/    ← GitHub Actions (sphinx.yml)
requirements.txt      ← Python deps for CI
Makefile / make.bat   ← local build shortcuts
sphinx.sh             ← local build helper (activates venv, runs make html/epub/latexpdf)
```

Built HTML (`.html`, `_static/`, `_images/`, etc.) is committed to the repo root on `gh-pages`. The `.gitignore` is tuned to keep build artifacts out of unintended `git add .` scope.

## Active courses (Fall 2026)

Current term is set in `docs/source/shared/this_term.rst`. Listed under "Current term's courses" in `index.rst`: COMP170, COMP271, COMP363.  
Listed under "Past (and possibly future) terms' courses": HONR204, COMP141, COMP163, COMP264, COMP306, COMP460, COMP397.

When the term changes, update `docs/source/shared/this_term.rst` and reorder the two toctrees in `docs/source/index.rst` to match.

## COMP 170 restructuring — important context

COMP 170 is being restructured into two new courses: **COMP 158** (14 weeks) and **COMP 159**. No separate directories for 158/159 have been created yet — all changes are currently made inside `docs/source/COMP170/`.

The revised outline integrates three parallel tracks:
1. **Python programming** — following *Think Python*, 3rd ed. (Allen Downey, free at greenteapress.com)
2. **Unix CLI tools** — following *The Linux Command Line*, 6th ed. (William Shotts, free at linuxcommand.org)
3. **Mathematical foundations** — logic, sets, functions, algorithm analysis — from course notes

**COMP 158** covers 14 weeks: environment setup → types/variables → conditionals/logic → functions → testing → lists/vectors → for loops/∑ → while/search/∃ → list comprehensions/strings → sets/file I/O → number representation → OOP intro → OOP design/relations → capstone project.

**COMP 159 weeks 1–7** (the part that maps to original COMP 170 scope): recursion/induction → recursion patterns/recurrences → Big-O analysis → sorting (selection, insertion, merge) → inheritance → polymorphism/linked structures → dictionaries/hashing.

Topics marked `[new]` in the outline have no counterpart in the original COMP 170. Topics marked `[new math]` come from COMP 163. Topics marked `[new CLI]` come from COMP 141.

OER abbreviations used in the outline:
- **TP** = Think Python 3rd ed.
- **TLCL** = The Linux Command Line 6th ed.
- **notes** = course repository mathematical notes

## COMP 170 reading material

`docs/source/COMP170/reading.rst` and `docs/source/COMP170/organization.rst` both list the course's OER textbooks: Think Python 3rd ed., The Linux Command Line 6th ed., and the course notes. There is no paid textbook for COMP 170 — keep these two files in sync if the reading list changes.

## GitHub Actions

`.github/workflows/sphinx.yml` is the only CI config (legacy `.travis.yml` and its helper script were removed). It builds on push to `gh-pages` and also supports manual `workflow_dispatch` runs from the GitHub UI, with `contents: write` permission to auto-commit built HTML back to the branch, and a `concurrency` block to queue rather than race on rapid pushes.

## Local build

```bash
# Quick HTML build
make html

# Or using the shell helper (activates venv if present)
./sphinx.sh
```

Output goes to `_build/` locally (Makefile default), not to `.` — that's only the CI target.

## Notes on .gitignore

The `.gitignore` on `gh-pages` acts as a filter for the CI `git add .` step, preventing source-control and config files from being swept into the built-output commit. `.github/` itself is gitignored (so the workflow file won't be re-committed by the build bot) but is still tracked from its original commit.
