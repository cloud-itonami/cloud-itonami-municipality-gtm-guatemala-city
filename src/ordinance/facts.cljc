(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Guatemala City -- the
  FORTY-EIGHTH municipality-level entry (see
  cloud-itonami-municipality-jpn-tokyo, -usa-washington-dc, -gbr-london,
  -can-toronto, -deu-berlin, -fra-paris, -nld-amsterdam, -esp-madrid,
  -kor-seoul, -ita-roma, -aus-sydney, -arg-buenos-aires, -fin-helsinki,
  -dnk-copenhagen, -nor-oslo, -bel-brussels, -chl-santiago, -col-bogota,
  -cri-san-jose, -bra-sao-paulo, -ury-montevideo, -zaf-cape-town,
  -ecu-quito, -swe-gothenburg, -pry-asuncion, -mex-guadalajara,
  -fra-lyon, -ind-new-delhi, -pol-warsaw, -ken-nairobi, -tha-bangkok,
  -are-abu-dhabi, -vnm-hanoi, -idn-jakarta, -phl-manila, -egy-cairo,
  -tur-ankara, -nga-abuja, -sau-riyadh, -mys-kuala-lumpur, -aut-vienna,
  -che-bern, -irl-dublin, -nzl-wellington, -cze-prague, -prt-lisbon,
  -pan-panama-city for the first forty-seven) per ADR-2607141700
  (cloud-itonami-compliance-fact-federation). Guatemala's first entry
  across the municipality axis, closing one of the 2 remaining
  structural country-without-municipality gaps identified at tick 141
  (GTM/HND).

  Guatemala City is Guatemala's stable capital (Wikidata Q1555), with
  no ongoing ambiguity about its CURRENT status, though its history
  involves capital relocations (the earlier colonial capital, Antigua
  Guatemala, was destroyed by earthquakes in 1773).

  Código Municipal (Decreto Número 12-2002 del Congreso de la
  República de Guatemala) -- title, decree number, and gazette date
  directly confirmed by reading the official Guatemalan government
  gazette (Diario de Centro América, the official organ of the
  Republic of Guatemala) cover page via the Read-tool saved-path
  fallback (WebFetch itself reported the PDF as illegible/binary),
  which shows verbatim: 'TOMO CCLXIX ... Guatemala, lunes 13 de mayo
  de 2002 ... NUMERO 12', 'CONGRESO DE LA REPUBLICA DE GUATEMALA',
  'DECRETO NUMERO 12-2002', and 'CODIGO MUNICIPAL'.

  The 1776 relocation of the seat of government to the CURRENT site
  of Guatemala City -- directly confirmed via en.wikipedia.org's own
  article, which states verbatim: 'In 1776, the seat of government
  was moved to the current location of Guatemala City, located in a
  valley less prone to earthquakes' and 'A series of devastating
  earthquakes in 1773 had left the old provincial capital Antigua
  Guatemala in ruins ... Thus, the Spanish decided to relocate the
  capital to somewhere safer.' This 1776 relocation date was chosen
  over Wikidata Q1555's own '25 July 1524' inception statement
  because the 1524 date refers to an earlier, geographically distinct
  Spanish settlement lineage (eventually Antigua Guatemala) rather
  than unambiguously the site of today's Guatemala City -- 1776 is
  the date directly and unambiguously tied to the CURRENT city's
  location in the source text.

  An ordinance not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"guatemala-city"
   [{:ordinance/id "guatemala-city.decreto-12-2002-codigo-municipal"
     :ordinance/title "Código Municipal (Decreto Número 12-2002 del Congreso de la República de Guatemala)"
     :ordinance/municipality "guatemala-city"
     :ordinance/country "GTM"
     :ordinance/kind :local-act
     :ordinance/number "Decreto 12-2002"
     :ordinance/url "https://portal.segeplan.gob.gt/segeplan/wp-content/uploads/2024/01/04.Dto_.-12-2002_Codigo-Municipal.pdf"
     :ordinance/url-provenance :official-diario-de-centro-america
     :ordinance/enacted-date "2002-05-13"
     :ordinance/retrieved-at "2026-07-18"
     :ordinance/topic #{:governance}}
    {:ordinance/id "guatemala-city.1776-relocation-current-site"
     :ordinance/title "The seat of government was moved to the current location of Guatemala City in 1776, following the 1773 earthquakes that destroyed the old colonial capital, Antigua Guatemala"
     :ordinance/municipality "guatemala-city"
     :ordinance/country "GTM"
     :ordinance/kind :local-act
     :ordinance/number "1776"
     :ordinance/url "https://en.wikipedia.org/wiki/Guatemala_City"
     :ordinance/url-provenance :wikipedia-corroborated
     :ordinance/enacted-date "1776"
     :ordinance/retrieved-at "2026-07-18"
     :ordinance/topic #{:governance}}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-gtm-guatemala-city Wave 0 (ADR-2607141700): "
                 (count (get catalog "guatemala-city")) " Guatemala City entries seeded "
                 "with Diario de Centro América/Wikipedia citations. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
