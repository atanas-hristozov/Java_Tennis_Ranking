# Tennis Ranking Algorithm

Tennis players constantly monitor their competitors' achievements to advance in rankings. This algorithm helps determine the final rankings after all tournaments in the current season.

## Input Data

Read from the console:
- First Line: Numbers N and K separated by a space.
  - N: Number of tennis players.
  - K: Number of changes in the ranking.
- Second Line: N player names separated by a space.
- Next K lines: Names of player pairs separated by a space.
  - First name: Player moving.
  - Second name: Player ahead in the ranking.

Sample Input:
5 3
Djoko Nadal Roger Alex Medi
Alex Djoko
Djoko Medi
Medi Alex


## Output Data

Print to the console:
- Final rankings of tennis players on one line.

Sample Output:
Medi Alex Nadal Roger Djoko


## Limits
- 1 <= N <= 2000
- 1 <= K <= 100,000
- Each name contains only letters and numbers.
- All names are unique.

## Sample Tests

### Test 1
Input:

7 4
Simona Aryna Iga Anett Maria Ons Paula
Simona Aryna
Aryna Simona
Aryna Paula
Paula Ons

Output:
