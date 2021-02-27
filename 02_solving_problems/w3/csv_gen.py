import pandas as pd
from pathlib import Path

current_dir = Path(__file__).absolute().parent

pd.DataFrame({'x1': [1, 2, 3],
              'x2': ['a', 'b', 'c']}).to_csv(current_dir/'demo.csv',
                                             index=False)
