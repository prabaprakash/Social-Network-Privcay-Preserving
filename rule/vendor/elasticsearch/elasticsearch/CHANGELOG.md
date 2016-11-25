## Release 2.0.3
- Prefer root_cause reason over the main reason if available [[aa2e313]](http://github.com/elasticsearch/elasticsearch-php/commit/aa2e313)
- Validate that index/type/id are non-null, non-empty when deleting [[8072aee]](http://github.com/elasticsearch/elasticsearch-php/commit/8072aee)
- Attempt to decode 400-level exceptions too [[9ab8904]](http://github.com/elasticsearch/elasticsearch-php/commit/9ab8904)
- [Docs] Header links are hard to see, make dedicated link [[7919ead]](http://github.com/elasticsearch/elasticsearch-php/commit/7919ead)
- Merge pull request #317 from ssm2003/patch-3 [[4147f16]](http://github.com/elasticsearch/elasticsearch-php/commit/4147f16)
- Merge pull request #316 from ssm2003/patch-2 [[d2b7552]](http://github.com/elasticsearch/elasticsearch-php/commit/d2b7552)
- Merge pull request #315 from ssm2003/patch-1 [[ad5f113]](http://github.com/elasticsearch/elasticsearch-php/commit/ad5f113)
- Populate lastRequestInfo with request/response [[68bfd10]](http://github.com/elasticsearch/elasticsearch-php/commit/68bfd10)
- [Docs] Add community integration page [[bcffa45]](http://github.com/elasticsearch/elasticsearch-php/commit/bcffa45)
- Merge pull request #313 from machour/patch-1 [[31137b3]](http://github.com/elasticsearch/elasticsearch-php/commit/31137b3)
- Fixed the bulk indexed with batches example [[80b7bdc]](http://github.com/elasticsearch/elasticsearch-php/commit/80b7bdc)


## Release 2.0.2
- Use curl opts for auth instead of inline syntax [[4b01af8]](http://github.com/elasticsearch/elasticsearch-php/commit/4b01af8)

## Release 2.0.1
- Add ClientBuilder::FromConfig to allow easier automated building of Client [[a07486d]](http://github.com/elasticsearch/elasticsearch-php/commit/a07486d)

## Release 2.0.0
- Added helper iterators for scrolled search [[24598e7]](http://github.com/elasticsearch/elasticsearch-php/commit/24598e7)
- comoposer command error [[8ed2885]](http://github.com/elasticsearch/elasticsearch-php/commit/8ed2885)

## Release 2.0.0-beta5
- [TESTS] Fix mistake due to poor cherry-picking skills :) [[1bae4ed]](http://github.com/elasticsearch/elasticsearch-php/commit/1bae4ed)
- Add Indices/ShardStores endpoint [[aa0f13f]](http://github.com/elasticsearch/elasticsearch-php/commit/aa0f13f)
- Add 'fields' param to Bulk Endpoint [[d434bf0]](http://github.com/elasticsearch/elasticsearch-php/commit/d434bf0)
- Add RenderSearchTemplate Endpoint [[dfd041d]](http://github.com/elasticsearch/elasticsearch-php/commit/dfd041d)
- Add `filter_path` to global param whitelist [[0943f73]](http://github.com/elasticsearch/elasticsearch-php/commit/0943f73)
- [TEST] Fix bug where inline stash replacements were not being honored [[a4d162e]](http://github.com/elasticsearch/elasticsearch-php/commit/a4d162e)
- [TEST] Fix stash replacement to make PHP 5.3 happy [[91a6e76]](http://github.com/elasticsearch/elasticsearch-php/commit/91a6e76)
- Add alias for TermVectors -> TermVector [[c4330e8]](http://github.com/elasticsearch/elasticsearch-php/commit/c4330e8)
- [TEST] fix bug where array_key_exists explodes due to doubles [[1b071b5]](http://github.com/elasticsearch/elasticsearch-php/commit/1b071b5)
- Add ''fielddata_fields' and 'filter_path'' param to Search whitelist [[2c2632f]](http://github.com/elasticsearch/elasticsearch-php/commit/2c2632f)
- Add 'human' param to Indices/Get whitelist [[e66197f]](http://github.com/elasticsearch/elasticsearch-php/commit/e66197f)
- Add Indices/GetUpgrade endpoint [[8bc2124]](http://github.com/elasticsearch/elasticsearch-php/commit/8bc2124)
- Add Indices/Upgrade endpoint [[138be12]](http://github.com/elasticsearch/elasticsearch-php/commit/138be12)
- Add Indices/flushSynced endpoint [[04d909b]](http://github.com/elasticsearch/elasticsearch-php/commit/04d909b)
- Add more missing query-string parameters [[a34c725]](http://github.com/elasticsearch/elasticsearch-php/commit/a34c725)
- Add missing query-string parameters [[f59a521]](http://github.com/elasticsearch/elasticsearch-php/commit/f59a521)
- Add missing whitelist parameters to SearchTemplate endpoint [[48aed04]](http://github.com/elasticsearch/elasticsearch-php/commit/48aed04)
- [TESTS] Add workaround for rest-spec package path change in core [[5f3939e]](http://github.com/elasticsearch/elasticsearch-php/commit/5f3939e)
- Add 'fields' parameter to FieldStats endpoint [[49a7ef4]](http://github.com/elasticsearch/elasticsearch-php/commit/49a7ef4)
- FieldStats endpoint accepts a body [[79a47cb]](http://github.com/elasticsearch/elasticsearch-php/commit/79a47cb)
- Add Cat/Segments Endpoint [[04a551f]](http://github.com/elasticsearch/elasticsearch-php/commit/04a551f)
- NoDocumentsToGetException needs nested original exception [[4b7e14e]](http://github.com/elasticsearch/elasticsearch-php/commit/4b7e14e)
- Fix error string handling when creating Exceptions [[f22c6c2]](http://github.com/elasticsearch/elasticsearch-php/commit/f22c6c2)


## Release 2.0.0-beta4
- [DOCS] Fix bulk example [[fce4848]](http://github.com/elasticsearch/elasticsearch-php/commit/fce4848)
- Add Indices/Seal endpoint [[a08252c]](http://github.com/elasticsearch/elasticsearch-php/commit/a08252c)
- [TEST] Fix YamlRunner to correctly stash values in object hierarchies [[2916727]](http://github.com/elasticsearch/elasticsearch-php/commit/2916727)
- Add SearchExists Endpoint [[a47eb67]](http://github.com/elasticsearch/elasticsearch-php/commit/a47eb67)
- Add more missing query-string parameters [[03bdb78]](http://github.com/elasticsearch/elasticsearch-php/commit/03bdb78)
- Add missing query-string parameters [[6efdedd]](http://github.com/elasticsearch/elasticsearch-php/commit/6efdedd)
- (pr/232) fix Warning for empty body when HEAD request - check if index exists [[e6fa2da]](http://github.com/elasticsearch/elasticsearch-php/commit/e6fa2da)

## Release 2.0.0-beta3

-  (HEAD, origin/2.0, 2.0) Add missing whitelist parameters to SearchTemplate endpoint [[74a7ca5]](http://github.com/elasticsearch/elasticsearch-php/commit/74a7ca5)
-  [TEST] Update version parsing to handle new format [[b86fca5]](http://github.com/elasticsearch/elasticsearch-php/commit/b86fca5)
-  Add FieldStats endpoint [[4935fd9]](http://github.com/elasticsearch/elasticsearch-php/commit/4935fd9)
-  Merge pull request #217 from simplechris/patch-4 [[5a92117]](http://github.com/elasticsearch/elasticsearch-php/commit/5a92117)
-  Add PSR-2 check to the contributing guidelines [[2ad3609]](http://github.com/elasticsearch/elasticsearch-php/commit/2ad3609)
-  Add .php_cs file [[17d0eac]](http://github.com/elasticsearch/elasticsearch-php/commit/17d0eac)
-  Add missing docblocks [[7305d45]](http://github.com/elasticsearch/elasticsearch-php/commit/7305d45)
-  Misc cleanup [[35cb77e]](http://github.com/elasticsearch/elasticsearch-php/commit/35cb77e)
-  Normalize blank lines between methods [[0f2cdae]](http://github.com/elasticsearch/elasticsearch-php/commit/0f2cdae)
-  Add blank line before 'return' statements to aid readability [[fabd2cc]](http://github.com/elasticsearch/elasticsearch-php/commit/fabd2cc)
-  Normalize spacing after explicit type casting [[057b1cd]](http://github.com/elasticsearch/elasticsearch-php/commit/057b1cd)
-  Remove unused 'use' statements [[f6b2882]](http://github.com/elasticsearch/elasticsearch-php/commit/f6b2882)
-  Normalize Elasticsearch\Common\Exception docblocks [[0a3a7ec]](http://github.com/elasticsearch/elasticsearch-php/commit/0a3a7ec)
-  Remove NamespaceFutureUtil trait [[9a75582]](http://github.com/elasticsearch/elasticsearch-php/commit/9a75582)
-  Remove commented-out debugging [[21c2278]](http://github.com/elasticsearch/elasticsearch-php/commit/21c2278)
-  Normalize docblocks [[eaf18e2]](http://github.com/elasticsearch/elasticsearch-php/commit/eaf18e2)
-  Remove redundant comments [[5c304a2]](http://github.com/elasticsearch/elasticsearch-php/commit/5c304a2)
-  Use PSR-2 coding standard [[ad3db43]](http://github.com/elasticsearch/elasticsearch-php/commit/ad3db43)
-  [TEST] Populate response body with exception message so that it can be verified [[65f1676]](http://github.com/elasticsearch/elasticsearch-php/commit/65f1676)
-  Merge pull request #220 from simplechris/fix/client-builder-handler-selection [[563124d]](http://github.com/elasticsearch/elasticsearch-php/commit/563124d)
-  ClientBuilder fixes for PHP 5.4 [[25eaa71]](http://github.com/elasticsearch/elasticsearch-php/commit/25eaa71)
-  Remove save_to streaming functionality - not needed with curl handlers [[f32e038]](http://github.com/elasticsearch/elasticsearch-php/commit/f32e038)
-  Merge pull request #216 from simplechris/patch-2 [[6cbe2fe]](http://github.com/elasticsearch/elasticsearch-php/commit/6cbe2fe)
-  Add missing use statements [[58527d5]](http://github.com/elasticsearch/elasticsearch-php/commit/58527d5)

## Release 2.0.0-beta2

- `curl_reset` was added in 5.5, use `curl_multi_init` to check for curl instead [[b722802]](http://github.com/elasticsearch/elasticsearch-php/commit/b722802)
- Update Composer.json with PSR-4 [[7bfd251]](http://github.com/elasticsearch/elasticsearch-php/commit/7bfd251)
- Add Cat\Plugins endpoint [[3044da9]](http://github.com/elasticsearch/elasticsearch-php/commit/3044da9)
- Indices/Stats endpoint should implode multi-valued metric parameters into a single string [[c2097b9]](http://github.com/elasticsearch/elasticsearch-php/commit/c2097b9)
- Fix typo in 'metric' argument of Stats function in IndicesNamespace.php [[db85afb]](http://github.com/elasticsearch/elasticsearch-php/commit/db85afb)
