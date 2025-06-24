import pandas as pd
import matplotlib.pyplot as plt
import matplotlib.ticker as ticker

data = pd.read_csv('results.csv')
plt.figure(figsize=(12, 6))
plt.plot(data['timeStamp'], data['elapsed'])
plt.xlabel('Время (мс)')
plt.ylabel('Время отлика (мс)')
plt.ylim( 500, max(data['elapsed']))
plt.axhline(y=840, color='red', linestyle='--', linewidth=2)
ax = plt.gca()
ax.yaxis.set_major_locator(ticker.MaxNLocator(nbins=20))
plt.show()