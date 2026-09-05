# cloud-itonami-municipality-gtm-guatemala-city

Municipal-ordinance compliance catalog for **Guatemala City** — the
FORTY-EIGHTH municipality-level entry, alongside 47 prior entries
including
[`cloud-itonami-municipality-pan-panama-city`](https://github.com/cloud-itonami/cloud-itonami-municipality-pan-panama-city),
[`cloud-itonami-municipality-prt-lisbon`](https://github.com/cloud-itonami/cloud-itonami-municipality-prt-lisbon),
and
[`cloud-itonami-municipality-cze-prague`](https://github.com/cloud-itonami/cloud-itonami-municipality-cze-prague).
Part of the [`cloud-itonami`](https://github.com/cloud-itonami)
compliance-fact family (ADR-2607141700,
`cloud-itonami-compliance-fact-federation`, in `com-junkawasaki/root`).

Guatemala's first entry across any of the 3 axes on the municipality
side — closing one of the 2 final structural country-without-municipality
gaps identified at tick 141 (GTM/HND).

## Sourcing note

The current governing law (Código Municipal, Decreto Número 12-2002)
is directly confirmed by reading the official Guatemalan government
gazette (Diario de Centro América) cover page via the Read-tool
saved-path fallback (WebFetch itself reported the PDF as
illegible/binary).

For the historical founding fact, Wikidata (Q1555) lists an inception
date of 25 July 1524, but this refers to an earlier, geographically
distinct Spanish settlement lineage (eventually Antigua Guatemala)
rather than unambiguously the site of today's Guatemala City. Instead,
this catalog uses the 1776 relocation of the seat of government to
the CURRENT location of Guatemala City, directly confirmed via
`en.wikipedia.org`, which is the date unambiguously tied to today's
city in the source text.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on Guatemala City's
behalf.

Coverage is reported honestly (see `ordinance.facts/coverage`): a
municipality not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/ordinance/facts.cljc` — the catalog, source of truth.
- `schema/ordinance.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

Six sources, all re-fetched live by `scripts/verify-facts.cljs`:
**Código Municipal** (Decreto 12-2002, gazetted 13 May 2002, official
PDF hosted by SEGEPLAN), **Acuerdo COM-21-2024** of the Concejo
Municipal (solvencia electrónica de transporte y tránsito / EMETRA,
as published by the official gazette's services host,
`servicios.dca.gob.gt`), the **Diario de Centro América** itself
(official gazette; both its site and its gazette-of-record status),
the **1776 relocation** of the seat of government to the current site
of Guatemala City (following the 1773 earthquakes that destroyed
Antigua Guatemala), and the Municipalidad's own **Visión de Ciudad**
urban-planning portal. Extended 2026-09-05 by the itonami ingest
scout: every citation was fetched live during that run.

Known-unreachable (measured 2026-09-05, NOT cited): `www.muniguate.com`
and `udi.muniguate.com` 301-redirect to `www5.munigate10.com`, which
does not resolve (NXDOMAIN). The municipalidad's principal web estate
is currently un-citable until that DNS record returns.

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Law text itself
remains Guatemala's; this repo stores only citation metadata
(id/title/url/dates), not full text.
